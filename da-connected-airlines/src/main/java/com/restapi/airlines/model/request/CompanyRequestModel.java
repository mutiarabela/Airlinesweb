package com.restapi.airlines.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CompanyRequestModel {

    @NotNull(message="Company ID must be filled")
    private Integer cId;

    @NotBlank(message="Company name must be filled")
    @Size(min=2, message="Company name must be filled")
    private String cName;

    @NotNull(message="Company Money must be filled")
    private double cBalance = 0.00;

}
