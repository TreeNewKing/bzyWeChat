package com.TreeNewKing.bzyWechat.error;

public class AppException extends RuntimeException{
    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }
}
