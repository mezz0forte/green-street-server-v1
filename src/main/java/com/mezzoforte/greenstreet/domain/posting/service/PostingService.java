package com.mezzoforte.greenstreet.domain.posting.service;

import com.mezzoforte.greenstreet.domain.posting.exception.PostingNotFoundException;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingRequest;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.UpdatePostingRequest;
import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.response.PostingResponse;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingRepository;
import com.mezzoforte.greenstreet.domain.user.domain.ro.UserRo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public List<PostingResponse> getPostingsByDistance(double latitude, double longitude) {

        List<Posting> postingList = postingRepository.findAll();


        return postingRepository.findAll()
                .stream().map((posting) -> new PostingResponse(
                        posting.getId(),
                        posting.getLatitude(),
                        posting.getLongitude(),
                        posting.getLikeCount(),
                        posting.getStatus(),
                        posting.getTitle(),
                        posting.getContent(),
                        new UserRo(posting.getUser().getId(), posting.getUser().getImage(), posting.getUser().getNickname())))
                .collect(Collectors.toList());
    }

    public Posting getPostingById(long id) {
        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> PostingNotFoundException.EXCEPTION);
        return posting;
    }

    public Posting createPosting(CreatePostingRequest dto) {

        // TODO : 유저 매개변수로 받아서 확인 후 posting 생성할 때 넣기

        Posting posting = Posting.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .status(PostingStatus.ACTIVE)
                .build();

        return posting;
    }

    public Posting updatePosting(long id, UpdatePostingRequest dto) {

        // TODO : 유저 매개변수로 받아서 본인 게시물인지 확인

        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> PostingNotFoundException.EXCEPTION);

        posting.modifyTitleAndContent(dto.getTitle(), dto.getContent());

        return posting;
    }

    public void deletePostingById(long id) {

        // TODO : 유저 매개변수로 받아서 본인 게시물인지 확인

        postingRepository.deleteById(id);
    }
}
