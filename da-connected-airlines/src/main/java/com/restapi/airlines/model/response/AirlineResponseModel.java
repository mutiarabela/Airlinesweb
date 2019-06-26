package com.restapi.airlines.model.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@NotNull
public class AirlineResponseModel { //For response or output

    private Integer aId;
    private String aName;
    private String aType;
    private String aAirportOrigin;
    private String aAirportDestin;
    private String aDestination;
    private double aPrice = 0.00;

}
