package com.mezzoforte.greenstreet.global.error.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class CredentialsNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new CredentialsNotFoundException();

    public CredentialsNotFoundException() {
        super(HttpStatus.UNAUTHORIZED, "토큰이 없습니다.");
    }
}
