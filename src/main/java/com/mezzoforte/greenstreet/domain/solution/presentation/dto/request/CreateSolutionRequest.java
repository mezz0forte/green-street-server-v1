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

    @NotBlank
    private String url;

    @NotNull
    private SolutionType type;

    @NotNull
    private long postingId;
}
