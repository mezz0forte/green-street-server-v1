package com.mezzoforte.greenstreet.domain.auth.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "해당 계정이 이미 있거나, 해당 전화번호의 계정이 이미 존재합니다.");
    }
}
