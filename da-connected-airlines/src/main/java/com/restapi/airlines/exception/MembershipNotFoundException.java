package com.restapi.airlines.exception;

public class MembershipNotFoundException extends RuntimeException { //Membership not found exception
    public MembershipNotFoundException(){ //Membership not found exception with default message
        super("Membership ID not Found");
    }
    public MembershipNotFoundException(String message){ //Membership not found exception with custom message
        super(message);
    }
}
