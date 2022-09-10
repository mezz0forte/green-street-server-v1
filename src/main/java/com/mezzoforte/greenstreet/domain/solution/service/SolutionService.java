package com.mezzoforte.greenstreet.domain.solution.service;

import com.mezzoforte.greenstreet.domain.solution.facade.SolutionFacade;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionRequest;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionRepository;
import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;
    private final SolutionFacade solutionFacade;

    public Page<Solution> getAll(Pageable pageable) {
        return solutionRepository.findAll(pageable);
    }

    public Solution getById(long id) {
        return solutionFacade.querySolutionById(id);
    }

    public void create(CreateSolutionRequest request) {


    }
}
