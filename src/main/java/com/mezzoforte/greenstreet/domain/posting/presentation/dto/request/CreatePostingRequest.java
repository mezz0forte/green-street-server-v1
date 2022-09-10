package com.mezzoforte.greenstreet.domain.posting.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CreatePostingRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private double latitude;

    @NotBlank
    private double longitude;
}
