package com.buchibanton.fashionblog.controller;

import com.buchibanton.fashionblog.exceptions.*;
import com.buchibanton.fashionblog.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(final UserNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("The user with this id does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(final UserAlreadyExists ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("This email already exists. Please check the email you inputted");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(final PostNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("This post does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(PostAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handlePostAlreadyExistsException(final PostAlreadyExists ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("This post does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAdminNotFoundException(final AdminNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Admin does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
    @ExceptionHandler(PostCommentAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handlePostCommentAlreadyExistsException(final PostCommentAlreadyExists ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Admin does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEmailException(final InvalidEmailException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Admin does not exist");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
