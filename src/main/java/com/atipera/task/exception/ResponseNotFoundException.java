package com.atipera.task.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseNotFoundException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public ResponseNotFoundException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

}
