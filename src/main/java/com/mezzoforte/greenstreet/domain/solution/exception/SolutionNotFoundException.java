package com.mezzoforte.greenstreet.domain.solution.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class SolutionNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new SolutionNotFoundException();

    private SolutionNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 솔루션을 찾을 수 없습니다.");
    }
}
