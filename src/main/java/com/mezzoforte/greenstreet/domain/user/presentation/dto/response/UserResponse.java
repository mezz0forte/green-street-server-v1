package com.mezzoforte.greenstreet.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {

    private long id;
    private String image;
    private String nickname;
}
