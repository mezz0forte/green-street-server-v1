package com.mezzoforte.greenstreet.domain.auth.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 유저를 찾지 못했습니다.");
    }
}
