package com.mezzoforte.greenstreet.domain.posting.presentation.dto.response;

import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.user.domain.ro.UserRo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostingResponse {

    private long id;
    private double latitude;
    private double longitude;
    private long likeCount;
    private PostingStatus status;
    private String title;
    private String content;
    private UserRo user;
}
