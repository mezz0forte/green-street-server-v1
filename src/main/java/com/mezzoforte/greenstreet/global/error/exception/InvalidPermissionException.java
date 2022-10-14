package com.mezzoforte.greenstreet.global.error.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class InvalidPermissionException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidPermissionException();

    private InvalidPermissionException() {
        super(HttpStatus.FORBIDDEN, "권한이 없습니다.");
    }
}
