package com.mezzoforte.greenstreet.reels.domain.repository;

import com.mezzoforte.greenstreet.reels.domain.entity.Reels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelsRepository extends JpaRepository<Reels, Long> {
}
