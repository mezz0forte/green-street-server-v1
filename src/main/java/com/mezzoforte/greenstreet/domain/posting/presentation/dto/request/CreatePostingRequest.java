package com.mezzoforte.greenstreet.domain.posting.presentation.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatePostingRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    private List<PhotoRequest> photos;

    @Getter
    public static class PhotoRequest {

        @NotBlank
        private String url;
    }
}