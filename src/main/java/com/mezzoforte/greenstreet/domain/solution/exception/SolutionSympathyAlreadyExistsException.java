package com.mezzoforte.greenstreet.domain.solution.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class SolutionSympathyAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new SolutionSympathyAlreadyExistsException();

    public SolutionSympathyAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "해당 솔루션 게시물의 공감이 이미 존재합니다.");
    }
}
