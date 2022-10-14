package com.mezzoforte.greenstreet.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;
}
