package com.dangki.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public static ApiException from(HttpStatus httpStatus){
        ApiException apiException = new ApiException();
        apiException.httpStatus = httpStatus;
        return apiException;
    }
    
    public ApiException message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
