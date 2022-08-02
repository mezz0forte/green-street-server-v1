package com.mezzoforte.greenstreet.reels.service;

import com.mezzoforte.greenstreet.common.exception.RecordNotFoundException;
import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.posting.domain.repository.PostingRepository;
import com.mezzoforte.greenstreet.reels.domain.dto.CreateReelsDto;
import com.mezzoforte.greenstreet.reels.domain.entity.Reels;
import com.mezzoforte.greenstreet.reels.domain.repository.ReelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReelsService {

    private final ReelsRepository reelsRepository;
    private final PostingRepository postingRepository;

    public List<Reels> getAllReels() {
        return reelsRepository.findAll();
    }

    public Reels getReelsById(long id) {
        Reels reels = reelsRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);
        return reels;
    }

    public Reels createReels(CreateReelsDto dto) {

        Posting posting = postingRepository.findById(dto.getPostingId())
                .orElseThrow(RecordNotFoundException::new);

        // TODO : Builder에 User 넣기

        Reels reels = Reels.builder()
                .video(dto.getVideo())
                .posting(posting)
                .build();

        return reels;
    }

    public void deleteReels(long id) {

        // TODO : TODO : 유저 매개변수로 받아서 본인 릴스인지 확인

        reelsRepository.deleteById(id);
    }
}
