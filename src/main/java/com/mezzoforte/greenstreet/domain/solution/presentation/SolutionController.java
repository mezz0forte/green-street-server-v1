package com.mezzoforte.greenstreet.domain.solution.presentation;

import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionRequest;
import com.mezzoforte.greenstreet.domain.solution.service.SolutionService;
import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/solution")
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Solution> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return solutionService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Solution getById(@PathVariable long id) {
        return solutionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateSolutionRequest request) {
        solutionService.create(request);
    }
}
