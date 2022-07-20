package com.buchibanton.fashionblog.exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(final String message) {
        super(message);
    }
}
