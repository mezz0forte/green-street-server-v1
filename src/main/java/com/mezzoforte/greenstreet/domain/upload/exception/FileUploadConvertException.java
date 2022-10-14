package com.mezzoforte.greenstreet.domain.upload.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class FileUploadConvertException extends CustomException {

    public static final CustomException EXCEPTION = new FileUploadConvertException();

    private FileUploadConvertException() {
        super(HttpStatus.BAD_REQUEST, "변환할 수 없는 파일입니다.");
    }
}
