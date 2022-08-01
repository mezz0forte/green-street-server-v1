package com.mezzoforte.greenstreet.posting.controller;

import com.mezzoforte.greenstreet.common.response.Response;
import com.mezzoforte.greenstreet.common.response.ResponseData;
import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posting")
@RestController
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/")
    public ResponseData<List<Posting>> getAllPostings() {
        List<Posting> postings = postingService.getAllPostings();
        return new ResponseData<>(HttpStatus.OK, "포스팅 조회 성공", postings);
    }

    @GetMapping("/{id}")
    public ResponseData<Posting> getPostingById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping("/")
    public ResponseData<Posting> postPosting() {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseData<Posting> patchPosting(@PathVariable("id") long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Response deletePosting(@PathVariable("id") long id) {
        return null;
    }
}
