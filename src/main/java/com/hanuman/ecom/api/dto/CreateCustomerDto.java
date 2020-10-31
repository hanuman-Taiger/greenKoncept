package com.hanuman.ecom.api.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateCustomerDto {

    @NotNull
    private String name;

    @NotNull
    private int age;

    private String address;

}
