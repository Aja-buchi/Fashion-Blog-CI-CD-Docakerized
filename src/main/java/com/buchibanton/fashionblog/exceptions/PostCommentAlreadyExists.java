package com.buchibanton.fashionblog.exceptions;

public class PostCommentAlreadyExists extends RuntimeException{
    public PostCommentAlreadyExists(final String message) {
        super(message);
    }
}
