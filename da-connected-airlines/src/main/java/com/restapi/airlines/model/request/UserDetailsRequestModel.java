package com.restapi.airlines.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequestModel { //For request or input

    @NotNull(message = "User ID must be filled")
    private Integer uId;

    @NotNull(message = "Company ID must be filled")
    private int cId;

    @NotNull(message = "MembershipService ID must be filled")
    private int mId;

    @NotBlank(message = "First must be filled")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String uFirstName;

    @NotBlank(message = "Last name must be filled")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String uLastName;

    @NotBlank(message = "First  must be filled")
    private String uPhoneNum;

    private String uName;

    @NotBlank(message = "Email name must be filled")
    @Email(message = "Email format is wrong")
    private String uEmail;

}
