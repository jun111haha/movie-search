package com.mymovie.movielog.member.exception;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException() {
        super("Member Not Founded");
    }

    public MemberNotFoundException(String msg) {
        super(msg);
    }

}
