package com.mezzoforte.greenstreet.reels.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
public class CreateReelsDto {

    @NotBlank
    private String video;

    @NotBlank
    private long postingId;
}
