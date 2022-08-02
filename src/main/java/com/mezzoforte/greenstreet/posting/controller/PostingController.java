package com.mezzoforte.greenstreet.posting.controller;

import com.mezzoforte.greenstreet.common.response.Response;
import com.mezzoforte.greenstreet.common.response.ResponseData;
import com.mezzoforte.greenstreet.posting.domain.dto.CreatePostingDto;
import com.mezzoforte.greenstreet.posting.domain.dto.UpdatePostingDto;
import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.posting.service.PostingService;
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

    @GetMapping("/")
    public ResponseData<List<Posting>> getAllPostings() {
        List<Posting> postings = postingService.getAllPostings();
        return new ResponseData<>(HttpStatus.OK, "모든 포스팅 조회 성공", postings);
    }

    @GetMapping("/{id}")
    public ResponseData<Posting> getPostingById(@PathVariable("id") long id) {
        Posting posting = postingService.getPostingById(id);
        return new ResponseData<>(HttpStatus.OK, "id로 포스팅 조회 성공", posting);
    }

    @PostMapping("/")
    public ResponseData<Posting> postPosting(@RequestBody @Valid CreatePostingDto dto) {
        Posting posting = postingService.createPosting(dto);
        return new ResponseData<>(HttpStatus.CREATED, "포스팅 생성 성공", posting);
    }

    @PatchMapping("/{id}")
    public ResponseData<Posting> patchPosting(@PathVariable("id") long id, @RequestBody UpdatePostingDto dto) {
        Posting posting = postingService.updatePosting(id, dto);
        return new ResponseData<>(HttpStatus.OK, "포스팅 수정 성공", posting);
    }

    @DeleteMapping("/{id}")
    public Response deletePosting(@PathVariable("id") long id) {
        postingService.deletePostingById(id);
        return new Response(HttpStatus.OK, "포스팅 삭제 성공");
    }
}
