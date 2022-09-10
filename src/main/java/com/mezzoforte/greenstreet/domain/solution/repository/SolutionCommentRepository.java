package com.mezzoforte.greenstreet.domain.solution.repository;

import com.mezzoforte.greenstreet.domain.solution.entity.SolutionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionCommentRepository extends JpaRepository<SolutionComment, Long> {
}
