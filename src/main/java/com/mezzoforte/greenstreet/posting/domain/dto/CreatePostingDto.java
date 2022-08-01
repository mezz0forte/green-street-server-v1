package com.mezzoforte.greenstreet.posting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CreatePostingDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private double latitude;

    @NotBlank
    private double longitude;
}
