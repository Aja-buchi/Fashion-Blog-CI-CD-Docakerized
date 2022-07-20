package com.buchibanton.fashionblog.exceptions;

public class PostAlreadyExists extends RuntimeException{
    public PostAlreadyExists(final String message) {
        super(message);
    }
}
