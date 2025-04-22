package com.explorer.user_service.exception;

public class InvalidRoleException extends RuntimeException {

    public InvalidRoleException(String role) {
        super("Invalid role '"+ role+"'. please enter correct role");
    }
}
