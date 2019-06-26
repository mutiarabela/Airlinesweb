package com.restapi.airlines.model.response;

import lombok.Data;

@Data
public class CompanyResponseModel {

    private Integer cId;
    private String cName;
    private double cBalance = 0.00;

}
