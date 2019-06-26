package com.restapi.airlines.exception;

public class CompanyNotFoundException extends RuntimeException { //Company not found exception
    public CompanyNotFoundException(){ //Company not found exception with default message
        super("Company ID not Found");
    }
    public CompanyNotFoundException(String message){ //Company not found exception with custom message
        super(message);
    }
}
