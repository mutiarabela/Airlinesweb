package com.restapi.airlines.model.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@NotNull
public class UserResponseModel { //For response or output


    private Integer uId;
    private Integer cId;
    private Integer mId;
    private String uFirstName;
    private String uLastName;
    private String uPhoneNum;
    private String uName;
    private String uEmail;

}
