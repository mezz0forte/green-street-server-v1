package com.mezzoforte.greenstreet.domain.solution.service;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.facade.PostingFacade;
import com.mezzoforte.greenstreet.domain.posting.repository.PostingRepository;
import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.solution.entity.SolutionComment;
import com.mezzoforte.greenstreet.domain.solution.entity.SolutionSympathy;
import com.mezzoforte.greenstreet.domain.solution.exception.SolutionSympathyAlreadyExistsException;
import com.mezzoforte.greenstreet.domain.solution.facade.SolutionCommentFacade;
import com.mezzoforte.greenstreet.domain.solution.facade.SolutionFacade;
import com.mezzoforte.greenstreet.domain.solution.facade.SolutionSympathyFacade;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionCommentRequest;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionRequest;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.CreateSolutionSympathyRequest;
import com.mezzoforte.greenstreet.domain.solution.presentation.dto.request.UpdateSolutionCommentRequest;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionCommentRepository;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionRepository;
import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.solution.repository.SolutionSympathyRepository;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.global.error.exception.InvalidPermissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;
    private final SolutionCommentRepository solutionCommentRepository;
    private final SolutionSympathyRepository solutionSympathyRepository;
    private final PostingRepository postingRepository;
    private final SolutionFacade solutionFacade;
    private final PostingFacade postingFacade;
    private final SolutionCommentFacade solutionCommentFacade;
    private final SolutionSympathyFacade solutionSympathyFacade;

    @Transactional(readOnly = true)
    public List<Solution> getSolutions(Pageable pageable) {
        return solutionFacade.queryAllSolution(pageable);
    }

    @Transactional(readOnly = true)
    public Solution getSolutionById(long id) {
        return solutionFacade.querySolutionById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void createSolution(CreateSolutionRequest request, User user) {

        Posting posting = postingFacade.queryPostingById(request.getPostingId());

        Solution solution = Solution.builder()
                .url(request.getUrl())
                .type(request.getType())
                .solver(user)
                .posting(posting)
                .build();

        posting.updateStatus(PostingStatus.DEACTIVATED);
        postingRepository.save(posting);

        solutionRepository.save(solution);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void createSolutionComment(CreateSolutionCommentRequest request, User user) {

        Solution solution = solutionFacade.querySolutionById(request.getSolutionId());

        SolutionComment solutionComment = SolutionComment.builder()
                .content(request.getContent())
                .solution(solution)
                .user(user)
                .build();

        solutionCommentRepository.save(solutionComment);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateSolutionComment(UpdateSolutionCommentRequest request, User user) {

        SolutionComment solutionComment = solutionCommentFacade.querySolutionCommentById(request.getPostingId());

        if (!user.equals(solutionComment.getUser())) {
            throw InvalidPermissionException.EXCEPTION;
        }

        solutionComment.updateCommentContent(request.getContent());
        solutionCommentRepository.save(solutionComment);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteCommentById(long id, User user) {

        SolutionComment solutionComment = solutionCommentFacade.querySolutionCommentById(id);

        if (!user.equals(solutionComment.getUser())) {
            throw InvalidPermissionException.EXCEPTION;
        }

        solutionCommentRepository.delete(solutionComment);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void createSolutionSympathy(CreateSolutionSympathyRequest request, User user) {

        Solution solution = solutionFacade.querySolutionById(request.getSolutionId());
        boolean existsSolutionSympathy = solutionSympathyRepository.existsBySolutionAndUser(solution, user);

        if (existsSolutionSympathy) {
            throw SolutionSympathyAlreadyExistsException.EXCEPTION;
        }

        SolutionSympathy solutionSympathy = SolutionSympathy.builder()
                .solution(solution)
                .user(user)
                .build();

        solutionSympathyRepository.save(solutionSympathy);

        solution.increaseSympathyCount();
        solutionRepository.save(solution);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteSolutionSympathy(long solutionId, User user) {

        Solution solution = solutionFacade.querySolutionById(solutionId);
        SolutionSympathy solutionSympathy = solutionSympathyFacade.querySolutionSympathyBySolutionAndUser(solution, user);

        solutionSympathyRepository.save(solutionSympathy);

        solution.decreaseSympathyCount();
        solutionRepository.save(solution);
    }
}
