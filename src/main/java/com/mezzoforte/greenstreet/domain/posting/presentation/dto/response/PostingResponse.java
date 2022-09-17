package com.mezzoforte.greenstreet.domain.posting.presentation.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingPhoto;
import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.user.domain.ro.UserRo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostingResponse {

    private long id;
    private double latitude;
    private double longitude;
    private long sympathyCount;
    private PostingStatus status;
    private String title;
    private String content;
    private UserRo user;
    private List<PostingPhoto> photoList;
}
