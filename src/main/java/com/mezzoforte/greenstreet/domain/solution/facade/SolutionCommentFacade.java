package com.mezzoforte.greenstreet.domain.solution.facade;

import com.mezzoforte.greenstreet.domain.solution.entity.SolutionComment;
import com.mezzoforte.greenstreet.domain.solution.exception.SolutionCommentNotFoundException;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SolutionCommentFacade {

    private final SolutionCommentRepository solutionCommentRepository;

    public SolutionComment querySolutionCommentById(long id) {
        return solutionCommentRepository.findById(id)
                .orElseThrow(() -> SolutionCommentNotFoundException.EXCEPTION);
    }
}
