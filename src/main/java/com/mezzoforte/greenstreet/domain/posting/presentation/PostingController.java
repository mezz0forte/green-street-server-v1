package com.mezzoforte.greenstreet.domain.posting.presentation;

import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingRequest;
import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingSympathyRequest;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.response.PostingResponse;
import com.mezzoforte.greenstreet.domain.posting.service.PostingService;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import com.mezzoforte.greenstreet.global.annotation.AuthorizationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posting")
@RestController
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/nearby")
    @ResponseStatus(HttpStatus.OK)
    public List<PostingResponse> getPostingsByDistance(@RequestParam double latitude, @RequestParam double longitude) {
        return postingService.getPostingsByDistance(latitude, longitude);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostingResponse getPostingById(@PathVariable("id") long id) {
        return postingService.getPostingById(id);
    }

    @AuthorizationCheck
    @GetMapping("/my")
    public List<PostingResponse> getPostingsByToken(@RequestAttribute User user) {
        return postingService.getPostingsByUser(user);
    }

    @AuthorizationCheck
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Posting createPosting(@RequestBody @Valid CreatePostingRequest request, @RequestAttribute User user) {
        return postingService.createPosting(request, user);
    }

    @AuthorizationCheck
    @PostMapping("/sympathy")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPostingSympathy(@RequestBody @Valid CreatePostingSympathyRequest request, @RequestAttribute User user) {
        postingService.createPostingSympathy(request, user);
    }

    @AuthorizationCheck
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosting(@PathVariable("id") long id, @RequestAttribute User user) {
        postingService.deletePostingById(id, user);
    }

    @AuthorizationCheck
    @DeleteMapping("/sympathy/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePostingSympathy(@PathVariable("id") long postingId, @RequestAttribute User user) {
        postingService.deletePostingSympathyByPostingId(postingId, user);
    }

}
