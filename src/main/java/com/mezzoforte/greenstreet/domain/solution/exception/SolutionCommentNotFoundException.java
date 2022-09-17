package com.mezzoforte.greenstreet.domain.solution.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class SolutionCommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new SolutionCommentNotFoundException();

    public SolutionCommentNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 해결 포스팅의 댓글을 찾지 못했습니다.");
    }
}
