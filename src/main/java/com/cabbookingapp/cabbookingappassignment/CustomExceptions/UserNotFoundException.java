package com.cabbookingapp.cabbookingappassignment.CustomExceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User not found: " + username);
    }
}
