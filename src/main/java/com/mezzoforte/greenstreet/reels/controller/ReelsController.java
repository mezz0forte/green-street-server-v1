package com.mezzoforte.greenstreet.reels.controller;

import com.mezzoforte.greenstreet.common.response.Response;
import com.mezzoforte.greenstreet.common.response.ResponseData;
import com.mezzoforte.greenstreet.reels.domain.dto.CreateReelsDto;
import com.mezzoforte.greenstreet.reels.domain.entity.Reels;
import com.mezzoforte.greenstreet.reels.service.ReelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reels")
public class ReelsController {

    private final ReelsService reelsService;

    @GetMapping("/")
    public ResponseData<List<Reels>> getAllReels() {
        List<Reels> reelsList = reelsService.getAllReels();
        return new ResponseData<>(HttpStatus.OK, "릴스 모두 조회 성공", reelsList);
    }

    @GetMapping("/{id}")
    public ResponseData<Reels> getReelsById(long id) {
        Reels reels = reelsService.getReelsById(id);
        return new ResponseData<>(HttpStatus.OK, "id로 릴스 조회 성공", reels);
    }

    @PostMapping("/")
    public ResponseData<Reels> postReels(@RequestBody @Valid CreateReelsDto dto) {
        Reels reels = reelsService.createReels(dto);
        return new ResponseData<>(HttpStatus.CREATED, "릴스 생성 성공", reels);
    }

    @DeleteMapping("/{id}")
    public Response deleteReelsById(@PathVariable long id) {
        reelsService.deleteReels(id);
        return new Response(HttpStatus.OK, "릴스 삭제 성공");
    }
}
