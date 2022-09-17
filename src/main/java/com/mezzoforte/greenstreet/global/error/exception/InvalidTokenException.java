package com.mezzoforte.greenstreet.global.error.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "토큰 값이 유효하지 않습니다.");
    }
}
