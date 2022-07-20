package com.buchibanton.fashionblog.exceptions;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(final String message) {
        super(message);
    }
}
