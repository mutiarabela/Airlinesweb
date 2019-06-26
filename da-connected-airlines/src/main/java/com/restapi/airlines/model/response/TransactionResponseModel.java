package com.restapi.airlines.model.response;

import lombok.Data;

@Data
public class TransactionResponseModel { //For response or output

    //private Integer tId;
    private double tTotPrice;
    private double tLuggage;
    private String uFirstName;
    private String uLastName;
    private String uPhoneNum;
    private String uEmail;
    private String aName;
    private String aDestination;
    private String aAirportOrigin;
    private String aAirportDestin;
    private double aPrice;
    private double mDiscount;
    private String mMessage;

}
