package com.parser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }
}
