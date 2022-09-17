package com.mezzoforte.greenstreet.domain.auth.presentation.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JoinRequest {

    @NotBlank
    private String phone;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @NotBlank
    private String image;
}