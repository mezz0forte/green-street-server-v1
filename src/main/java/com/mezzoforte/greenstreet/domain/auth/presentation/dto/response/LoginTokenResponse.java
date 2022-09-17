package com.mezzoforte.greenstreet.domain.auth.presentation.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mezzoforte.greenstreet.domain.user.presentation.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LoginTokenResponse {

    private UserResponse user;
    private String accessToken;
    private String refreshToken;
}
