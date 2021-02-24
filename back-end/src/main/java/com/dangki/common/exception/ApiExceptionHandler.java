package com.dangki.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorMessage handleAllException(Exception ex , WebRequest webRequest){
//        return new ErrorMessage(500,ex.getLocalizedMessage());
//    }
//    @ExceptionHandler(ApiException.class)
//    public ErrorMessage handleApiException(ApiException ex){
//        return new ErrorMessage(ex.getHttpStatus().value(),ex.getMessage());
//    }
}
