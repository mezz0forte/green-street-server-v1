package com.mezzoforte.greenstreet.posting.service;

import com.mezzoforte.greenstreet.common.exception.RecordNotFoundException;
import com.mezzoforte.greenstreet.posting.domain.dto.CreatePostingDto;
import com.mezzoforte.greenstreet.posting.domain.dto.UpdatePostingDto;
import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.posting.domain.enums.PostingStatus;
import com.mezzoforte.greenstreet.posting.domain.repository.PostingRepository;
import com.mezzoforte.greenstreet.posting.domain.ro.PostingRo;
import com.mezzoforte.greenstreet.user.domain.ro.UserRo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public List<PostingRo> getPostingsByDistance(double latitude, double longitude) {
        return postingRepository.findAll()
                .stream().map((posting) -> new PostingRo(
                        posting.getId(),
                        posting.getLatitude(),
                        posting.getLongitude(),
                        posting.getLikeCount(),
                        posting.getStatus(),
                        posting.getTitle(),
                        posting.getContent(),
                        new UserRo(posting.getUser().getId(), posting.getUser().getImage(), posting.getUser().getNickname())))
                .collect(Collectors.toList());
    }

    public Posting getPostingById(long id) {
        Posting posting = postingRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);
        return posting;
    }

    public Posting createPosting(CreatePostingDto dto) {

        // TODO : 유저 매개변수로 받아서 확인 후 posting 생성할 때 넣기

        Posting posting = Posting.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .status(PostingStatus.ACTIVE)
                .build();

        return posting;
    }

    public Posting updatePosting(long id, UpdatePostingDto dto) {

        // TODO : 유저 매개변수로 받아서 본인 게시물인지 확인

        Posting posting = postingRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);

        posting.modifyTitleAndContent(dto.getTitle(), dto.getContent());

        return posting;
    }

    public void deletePostingById(long id) {

        // TODO : 유저 매개변수로 받아서 본인 게시물인지 확인

        postingRepository.deleteById(id);
    }
}
