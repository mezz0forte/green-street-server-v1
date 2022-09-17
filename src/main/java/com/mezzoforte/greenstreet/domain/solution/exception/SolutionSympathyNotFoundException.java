package com.mezzoforte.greenstreet.domain.solution.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class SolutionSympathyNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new SolutionSympathyNotFoundException();

    public SolutionSympathyNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 솔루션의 공감을 찾을 수 없습니다.");
    }
}
