package com.example.Zoomanager.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }
    public BadRequestException(String errMsg) {
        super(errMsg);
    }
}
