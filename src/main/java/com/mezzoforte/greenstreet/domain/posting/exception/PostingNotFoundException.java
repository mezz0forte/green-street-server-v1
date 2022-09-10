package com.mezzoforte.greenstreet.domain.posting.exception;

import com.mezzoforte.greenstreet.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class PostingNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new PostingNotFoundException();

    private PostingNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 포스팅을 찾을 수 없습니다.");
    }
}
