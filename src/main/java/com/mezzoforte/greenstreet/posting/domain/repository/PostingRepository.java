package com.mezzoforte.greenstreet.posting.domain.repository;

import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

}
