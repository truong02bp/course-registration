package com.dangki.common.exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private int httpStatus;
    private String message;

    public ErrorMessage(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
