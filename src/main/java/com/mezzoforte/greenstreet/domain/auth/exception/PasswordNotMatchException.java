package com.mezzoforte.greenstreet.domain.auth.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class PasswordNotMatchException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordNotMatchException();

    private PasswordNotMatchException() {
        super(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
    }
}
