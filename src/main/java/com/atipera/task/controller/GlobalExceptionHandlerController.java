package com.atipera.task.controller;

import com.atipera.task.exception.ApiError;
import com.atipera.task.exception.ResponseNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseNotFoundException.class)
    protected ResponseEntity<Object> handleGitHubNotFoundException(ResponseNotFoundException ex) {
        ApiError apiError = new ApiError(ex.getStatus(), ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
