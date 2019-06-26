package com.restapi.airlines.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MembershipRequestModel {

    @NotBlank(message="Membership ID must be filled")
    private Integer mId;

    @NotBlank(message="Membership Name must be filled")
    @Size(min=2, message="Membership name must be filled")
    private String mName;

    @NotBlank(message="Membership Message must be filled")
    @Size(min=2, message="Membership Message must be filled")
    private String mMessage;

    @NotNull(message="MembershipService Discount must be filled")
    private double mDiscount = 0.00;

}
