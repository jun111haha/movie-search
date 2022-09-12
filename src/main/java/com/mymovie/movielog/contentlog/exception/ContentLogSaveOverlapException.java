package com.mymovie.movielog.contentlog.exception;

public class ContentLogSaveOverlapException extends RuntimeException{
    public ContentLogSaveOverlapException() {
        super("Content Save OverLap");
    }

    public ContentLogSaveOverlapException(String msg) {
        super(msg);
    }
}
