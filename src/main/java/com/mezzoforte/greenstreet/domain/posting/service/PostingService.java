package com.mezzoforte.greenstreet.domain.posting.service;

import com.mezzoforte.greenstreet.domain.posting.entity.PostingPhoto;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingSympathy;
import com.mezzoforte.greenstreet.domain.posting.exception.PostingSympathyAlreadyExistsException;
import com.mezzoforte.greenstreet.domain.posting.facade.PostingFacade;
import com.mezzoforte.greenstreet.domain.posting.facade.PostingSympathyFacade;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingRequest;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingSympathyRequest;
import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingPhotoRepository;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingSympathyRepository;
import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.response.PostingResponse;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.domain.user.presentation.dto.response.UserResponse;
import com.mezzoforte.greenstreet.global.error.exception.InvalidPermissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final PostingPhotoRepository postingPhotoRepository;
    private final PostingSympathyRepository postingSympathyRepository;
    private final PostingFacade postingFacade;
    private final PostingSympathyFacade postingSympathyFacade;

    @Transactional(readOnly = true)
    public List<PostingResponse> getPostingsByDistance(double latitude, double longitude) {

        return postingFacade.queryAllPostings()
                .stream().map((posting) -> new PostingResponse(
                        posting.getId(),
                        posting.getLatitude(),
                        posting.getLongitude(),
                        posting.getSympathyCount(),
                        posting.getStatus(),
                        posting.getTitle(),
                        posting.getContent(),
                        new UserResponse(posting.getUser().getId(),  posting.getUser().getPhone(), posting.getUser().getImage(), posting.getUser().getNickname()),
                        posting.getPhotoList()
                )).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Posting getPostingById(long id) {
        return postingFacade.queryPostingById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public Posting createPosting(CreatePostingRequest request, User user) {

        Posting posting = Posting.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .status(PostingStatus.ACTIVE)
                .user(user)
                .build();

        postingRepository.save(posting);

        int sequence = 1;

        for (CreatePostingRequest.PhotoRequest photoRequest : request.getPhotos()) {
            PostingPhoto postingPhoto = PostingPhoto.builder()
                    .posting(posting)
                    .imageUrl(photoRequest.getUrl())
                    .sequence(sequence)
                    .build();
            postingPhotoRepository.save(postingPhoto);
            sequence++;
        }

        return posting;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deletePostingById(long id, User user) {

        Posting posting = postingFacade.queryPostingById(id);

        if(!user.equals(posting.getUser())) {
            throw InvalidPermissionException.EXCEPTION;
        }

        postingPhotoRepository.deleteAllByPosting(posting);
        postingRepository.deleteById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void createPostingSympathy(CreatePostingSympathyRequest request, User user) {

        Posting posting = postingFacade.queryPostingById(request.getPostingId());
        boolean existsPostingSympathy = postingSympathyRepository.existsByPostingAndUser(posting, user);

        if(existsPostingSympathy) {
            throw PostingSympathyAlreadyExistsException.EXCEPTION;
        }

        PostingSympathy postingSympathy = PostingSympathy.builder()
                .posting(posting)
                .user(user)
                .build();

        postingSympathyRepository.save(postingSympathy);

        posting.increaseSympathyCount();
        postingRepository.save(posting);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deletePostingSympathyByPostingId(long postingId, User user) {

        Posting posting = postingFacade.queryPostingById(postingId);
        PostingSympathy postingSympathy = postingSympathyFacade.queryPostingSympathyByPostingAndUser(posting, user);

        postingSympathyRepository.delete(postingSympathy);

        posting.decreaseSympathyCount();
        postingRepository.save(posting);
    }
}
