package com.mymovie.movielog.exception;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException{
    /**
     * API 관련 오류 정의
     */
    private final String errCode;

    public APIException(String message, String errCode) {
        super(message, null, false, false);
        this.errCode = errCode;
    }
}
