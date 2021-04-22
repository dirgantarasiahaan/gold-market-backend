package com.mandiri.pocket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.RuntimeErrorException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Error e) {
        super(e);
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
