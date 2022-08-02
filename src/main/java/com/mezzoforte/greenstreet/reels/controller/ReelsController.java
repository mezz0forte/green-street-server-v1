package com.mezzoforte.greenstreet.reels.controller;

import com.mezzoforte.greenstreet.common.response.Response;
import com.mezzoforte.greenstreet.common.response.ResponseData;
import com.mezzoforte.greenstreet.reels.domain.dto.CreateReelsDto;
import com.mezzoforte.greenstreet.reels.domain.entity.Reels;
import com.mezzoforte.greenstreet.reels.service.ReelsService;
import lombok.RequiredArgsConstructor;
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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseData<Reels> getReelsById(long id) {
        return null;
    }

    @PostMapping("/")
    public ResponseData<Reels> postReels(@RequestBody @Valid CreateReelsDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Response deleteReelsById(@PathVariable long id) {
        return null;
    }
}
