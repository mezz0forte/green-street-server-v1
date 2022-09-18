package com.mezzoforte.greenstreet.domain.upload.exception;

import com.mezzoforte.greenstreet.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class FileUploadIOException extends CustomException {

    public static final CustomException EXCEPTION = new FileUploadIOException();

    private FileUploadIOException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드 중 서버 오류가 발생했습니다.");
    }
}
