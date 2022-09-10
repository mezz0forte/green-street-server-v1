package com.mezzoforte.greenstreet.domain.solution.presentation.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mezzoforte.greenstreet.domain.solution.type.SolutionType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateSolutionRequest {

    @NotBlank(message = "url must not be empty")
    private String url;

    @NotNull(message = "type (IMAGE, VIDEO) must not be null")
    private SolutionType type;

    @NotNull(message = "postingId must not be null")
    private long postingId;
}
