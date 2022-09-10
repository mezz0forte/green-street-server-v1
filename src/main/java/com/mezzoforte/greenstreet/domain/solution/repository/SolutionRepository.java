package com.mezzoforte.greenstreet.domain.solution.repository;

import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {

    Page<Solution> findAll(Pageable pageable);
}
