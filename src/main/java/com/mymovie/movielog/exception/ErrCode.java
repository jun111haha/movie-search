package com.mymovie.movielog.exception;

public enum ErrCode {

    // HttpStatus 401
    E0000("000", "예상치 못한 오류가 발생하였습니다."),
    E0103("103", "유저 아이디가 존재하지 않습니다.");


    public final String code;
    public final String errMsg;

    ErrCode(String code, String errMsg){
        this.code = code;
        this.errMsg = errMsg;
    }

    public String getCode(){
        return code;
    }

    public String getErrMsg(){
        return  errMsg;
    }
}
