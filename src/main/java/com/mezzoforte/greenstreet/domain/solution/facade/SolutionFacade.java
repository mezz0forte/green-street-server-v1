package com.mezzoforte.greenstreet.domain.solution.facade;

import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.solution.entity.SolutionComment;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionCommentRepository;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionRepository;
import com.mezzoforte.greenstreet.domain.solution.exception.SolutionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SolutionFacade {

    private final SolutionRepository solutionRepository;
    private final SolutionCommentRepository solutionCommentRepository;

    public List<Solution> queryAllSolution(Pageable pageable) {
        List<Solution> solutionList = solutionRepository.findAll(pageable).getContent();
        for(Solution solution : solutionList) {
            List<SolutionComment> commentList = solutionCommentRepository.findAllBySolution(solution);
            solution.injectCommentList(commentList);
        }
        return solutionList;
    }

    public Solution querySolutionById(long id) {
        Solution solution = solutionRepository.findById(id)
                .orElseThrow(() -> SolutionNotFoundException.EXCEPTION);
        List<SolutionComment> solutionCommentList = solutionCommentRepository.findAllBySolution(solution);
        solution.injectCommentList(solutionCommentList);
        return solution;
    }
}
