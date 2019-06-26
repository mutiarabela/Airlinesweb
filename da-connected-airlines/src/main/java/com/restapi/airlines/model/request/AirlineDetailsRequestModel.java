package com.restapi.airlines.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AirlineDetailsRequestModel { //For request or input

    @NotBlank(message="Airline ID must be filled")
    private Integer aId;

    @NotBlank(message="Airline name must be filled")
    @Size(min=2, message="Airline name must be filled")
    private String aName;

    @NotBlank(message="Type of plane must be filled")
    private String aType;

    @NotBlank(message="Airport Origin must be filled")
    private String aAirportOrigin;

    @NotBlank(message="Airport Destination must be filled")
    private String aAirportDestin;

    @NotBlank(message="Destination name must be filled")
    private String aDestination;

    @NotNull(message="Price must be filled")
    private double aPrice = 0.00;

}
