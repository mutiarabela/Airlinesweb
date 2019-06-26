package com.restapi.airlines.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@NotNull
public class TransactionRequestModel { //For request or input

    //private Integer tId;
    private Integer uId;
    private Integer aId;
    private double tLuggage = 0.00;

}
