package com.mezzoforte.greenstreet.domain.posting.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class PostingSympathyAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new PostingSympathyAlreadyExistsException();

    public PostingSympathyAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "해당 게시물의 공감이 이미 존재합니다.");
    }
}
