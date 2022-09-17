package com.mezzoforte.greenstreet.domain.posting.presentation;

import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingRequest;
import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.request.CreatePostingSympathyRequest;
import com.mezzoforte.greenstreet.domain.posting.presentation.dto.response.PostingResponse;
import com.mezzoforte.greenstreet.domain.posting.service.PostingService;
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
    public Posting getPostingById(@PathVariable("id") long id) {
        return postingService.getPostingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Posting createPosting(@RequestBody @Valid CreatePostingRequest request) {
        return postingService.createPosting(request);
    }

    @PostMapping("/sympathy")
    @ResponseStatus(HttpStatus.CREATED)
    public Posting createPostingSympathy(@RequestBody @Valid CreatePostingSympathyRequest request) {
        return postingService.createPostingSympathy(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosting(@PathVariable("id") long id) {
        postingService.deletePostingById(id);
    }
}
