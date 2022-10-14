package com.mezzoforte.greenstreet.domain.posting.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class PostingSympathyNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new PostingSympathyNotFoundException();

    public PostingSympathyNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 포스팅의 공감을 찾을 수 없습니다.");
    }
}
