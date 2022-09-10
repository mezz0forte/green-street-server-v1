package com.mezzoforte.greenstreet.domain.solution.facade;

import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionRepository;
import com.mezzoforte.greenstreet.domain.solution.exception.SolutionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SolutionFacade {

    private final SolutionRepository solutionRepository;

    public Solution querySolutionById(long id) {
        return solutionRepository.findById(id)
                .orElseThrow(() -> SolutionNotFoundException.EXCEPTION);
    }
}
