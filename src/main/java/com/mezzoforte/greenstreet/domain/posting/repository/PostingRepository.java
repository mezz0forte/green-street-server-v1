package com.mezzoforte.greenstreet.domain.posting.repository;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

}
