package com.restapi.airlines.exception;

public class UserNotFoundException extends RuntimeException { //User not found
    public UserNotFoundException() { //User not found with default message
        super("User ID not Found");
    }
    public UserNotFoundException(String message) { //User not found by custom message
        super(message);
    }
}
