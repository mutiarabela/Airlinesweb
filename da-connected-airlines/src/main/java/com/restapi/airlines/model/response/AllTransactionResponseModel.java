package com.restapi.airlines.model.response;

import lombok.Data;

import java.util.Collection;

@Data
public class AllTransactionResponseModel { //For all transaction output

    private Collection transaction;
    private double totalTransaction = 0.00;

}
