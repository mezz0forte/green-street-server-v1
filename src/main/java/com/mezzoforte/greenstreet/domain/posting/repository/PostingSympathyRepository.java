package com.mezzoforte.greenstreet.domain.posting.repository;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingSympathy;
import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostingSympathyRepository extends JpaRepository<PostingSympathy, Long> {

    Optional<PostingSympathy> findByPostingAndUser(Posting posting, User user);
    boolean existsByPostingAndUser(Posting posting, User user);
}
