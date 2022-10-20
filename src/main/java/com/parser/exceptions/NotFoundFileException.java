package com.parser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundFileException extends Exception{

    public NotFoundFileException(String message) {
        super(message);
    }
}
