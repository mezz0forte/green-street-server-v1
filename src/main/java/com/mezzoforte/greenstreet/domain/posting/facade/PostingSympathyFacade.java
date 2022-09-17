package com.mezzoforte.greenstreet.domain.posting.facade;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingSympathy;
import com.mezzoforte.greenstreet.domain.posting.exception.PostingSympathyNotFoundException;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingSympathyRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostingSympathyFacade {

    private final PostingSympathyRepository postingSympathyRepository;

    public PostingSympathy getPostingSympathyByPostingAndUser(Posting posting, User user) {
        return postingSympathyRepository.findByPostingAndUser(posting, user)
                .orElseThrow(() -> PostingSympathyNotFoundException.EXCEPTION);
    }
}
