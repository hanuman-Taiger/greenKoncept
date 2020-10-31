package com.hanuman.ecom.api.dto;

import com.hanuman.ecom.domain.Order;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateOrderDto {

    @NotNull
    private String details;

    @NotNull
    private float amount;

    @NotNull
    private long custId;
}
