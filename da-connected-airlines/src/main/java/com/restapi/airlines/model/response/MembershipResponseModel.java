package com.restapi.airlines.model.response;

import lombok.Data;

@Data
public class MembershipResponseModel {

    private Integer mId;
    private String mName;
    private String mMessage;
    private double mDiscount = 0.00;

}
