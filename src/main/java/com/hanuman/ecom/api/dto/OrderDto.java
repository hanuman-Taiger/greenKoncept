package com.hanuman.ecom.api.dto;

import com.hanuman.ecom.domain.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {

    private Long id;

    private String details;

    private float amount;

    private CustomerDto customer;

    public static OrderDto of(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .details(order.getDetails())
                .amount(order.getAmount())
                .customer(CustomerDto.of(order.getCustomer()))
                .build();
    }
}
