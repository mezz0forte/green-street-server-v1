package com.mezzoforte.greenstreet.domain.user.repository;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhone(String phone);
    boolean existsByPhone(String phone);
}
