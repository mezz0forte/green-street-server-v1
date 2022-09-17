package com.mezzoforte.greenstreet.domain.user.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 계정의 유저를 찾을 수 없거나, ID가 틀렸습니다.");
    }
}
