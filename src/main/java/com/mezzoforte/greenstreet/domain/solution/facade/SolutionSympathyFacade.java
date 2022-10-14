package com.mezzoforte.greenstreet.domain.solution.facade;

import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.solution.entity.SolutionSympathy;
import com.mezzoforte.greenstreet.domain.solution.exception.SolutionSympathyNotFoundException;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionSympathyRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolutionSympathyFacade {

    private final SolutionSympathyRepository solutionSympathyRepository;

    public SolutionSympathy querySolutionSympathyBySolutionAndUser(Solution solution, User user) {
        return solutionSympathyRepository.findBySolutionAndUser(solution, user)
                .orElseThrow(() -> SolutionSympathyNotFoundException.EXCEPTION);
    }
}
