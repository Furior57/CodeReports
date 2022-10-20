package com.parser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidFormatFileException extends Exception {

    public InvalidFormatFileException(String message) {
        super(message);
    }
}
