package com.mezzoforte.greenstreet.domain.posting.facade;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.exception.PostingNotFoundException;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostingFacade {

    private final PostingRepository postingRepository;

    public Posting getPostingById(long id) {
        return postingRepository.findById(id)
                .orElseThrow(() -> PostingNotFoundException.EXCEPTION);
    }
}
