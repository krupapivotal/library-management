package com.explorer.user_service.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long userId) {
        super("User not found exception for the given id :: " +userId);
    }
}
