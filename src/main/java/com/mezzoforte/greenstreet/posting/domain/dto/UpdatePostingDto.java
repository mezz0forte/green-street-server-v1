package com.mezzoforte.greenstreet.posting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePostingDto {

    private String title;
    private String content;
}
