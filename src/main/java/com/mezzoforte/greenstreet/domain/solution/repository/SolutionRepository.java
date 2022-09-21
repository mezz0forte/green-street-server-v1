package com.mezzoforte.greenstreet.domain.solution.repository;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {

    Page<Solution> findAll(Pageable pageable);
    Optional<Solution> findByPosting(Posting posting);
}
