package com.mezzoforte.greenstreet.posting.domain.ro;

import com.mezzoforte.greenstreet.posting.domain.enums.PostingStatus;
import com.mezzoforte.greenstreet.user.domain.ro.UserRo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostingRo {

    private long id;
    private double latitude;
    private double longitude;
    private long likeCount;
    private PostingStatus status;
    private String title;
    private String content;
    private UserRo user;
}
