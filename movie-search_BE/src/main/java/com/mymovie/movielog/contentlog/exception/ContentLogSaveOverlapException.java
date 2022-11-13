package com.mymovie.movielog.contentlog.exception;

public class ContentLogSaveOverlapException extends RuntimeException{
    public ContentLogSaveOverlapException() {
        super("로그에 동일한 컨텐츠가 있습니다!");
    }

    public ContentLogSaveOverlapException(String msg) {
        super(msg);
    }
}
