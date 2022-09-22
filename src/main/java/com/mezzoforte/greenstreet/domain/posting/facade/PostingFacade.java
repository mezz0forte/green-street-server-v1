package com.mezzoforte.greenstreet.domain.posting.facade;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingPhoto;
import com.mezzoforte.greenstreet.domain.posting.exception.PostingNotFoundException;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingPhotoRepository;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostingFacade {

    private final PostingRepository postingRepository;
    private final PostingPhotoRepository postingPhotoRepository;

    public List<Posting> queryAllPostings() {
        List<Posting> postingList = postingRepository.findAll();
        for (Posting posting : postingList) {
            List<PostingPhoto> photoList = postingPhotoRepository.findAllByPosting(posting);
            posting.injectPostingPhotoList(photoList);
        }
        return postingList;
    }

    public List<Posting> queryPostingsByUser(User user) {
        List<Posting> postingList = postingRepository.findAllByUser(user);
        for (Posting posting : postingList) {
            List<PostingPhoto> photoList = postingPhotoRepository.findAllByPosting(posting);
            posting.injectPostingPhotoList(photoList);
        }
        return postingList;
    }

    public Posting queryPostingById(long id) {
        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> PostingNotFoundException.EXCEPTION);
        List<PostingPhoto> postingPhotoList = postingPhotoRepository.findAllByPosting(posting);
        posting.injectPostingPhotoList(postingPhotoList);
        return posting;
    }
}
