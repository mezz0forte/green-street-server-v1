package com.mezzoforte.greenstreet.posting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class UpdatePostingDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
