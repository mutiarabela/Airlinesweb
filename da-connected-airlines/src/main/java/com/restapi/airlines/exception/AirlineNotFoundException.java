package com.restapi.airlines.exception;

public class AirlineNotFoundException extends RuntimeException { //Airline not found exception
    public AirlineNotFoundException(){ //Airline not found exception with default message
        super("Airline ID not Found");
    }
    public AirlineNotFoundException(String message){ //Airline not found exception with custom message
        super(message);
    }
}
