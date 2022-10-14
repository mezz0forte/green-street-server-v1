package com.mezzoforte.greenstreet.global.error.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class EncryptException extends CustomException {

    public static final CustomException EXCEPTION = new EncryptException();

    private EncryptException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "암호화 중 오류가 발생하였습니다.");
    }
}
