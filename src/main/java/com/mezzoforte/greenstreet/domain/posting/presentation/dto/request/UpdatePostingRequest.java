package com.mezzoforte.greenstreet.domain.posting.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class UpdatePostingRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
