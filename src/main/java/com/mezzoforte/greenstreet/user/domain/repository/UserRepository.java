package com.mezzoforte.greenstreet.user.domain.repository;

import com.mezzoforte.greenstreet.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
