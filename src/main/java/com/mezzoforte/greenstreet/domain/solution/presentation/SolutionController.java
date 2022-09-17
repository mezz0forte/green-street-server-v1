package com.mezzoforte.greenstreet.domain.solution.presentation;

import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionCommentRequest;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionRequest;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.UpdateSolutionCommentRequest;
import com.mezzoforte.greenstreet.domain.solution.service.SolutionService;
import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.global.annotation.AuthorizationCheck;
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
    public Page<Solution> getSolutions(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return solutionService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Solution getSolutionById(@PathVariable long id) {
        return solutionService.getById(id);
    }

    @AuthorizationCheck
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSolution(@RequestBody CreateSolutionRequest request, @RequestAttribute User user) {
        solutionService.create(request);
    }

    @AuthorizationCheck
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSolutionComment(@RequestBody CreateSolutionCommentRequest request, @RequestAttribute User user) {

    }

    @AuthorizationCheck
    @PatchMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSolutionComment(@PathVariable long id, @RequestBody UpdateSolutionCommentRequest request, @RequestAttribute User user) {

    }

    @AuthorizationCheck
    @DeleteMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable long id, @RequestAttribute User user) {

    }
}
