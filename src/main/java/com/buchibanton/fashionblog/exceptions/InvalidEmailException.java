package com.buchibanton.fashionblog.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(final String message) {
        super(message);
    }
}
