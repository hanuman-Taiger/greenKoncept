package com.hanuman.ecom.api.dto;

import com.hanuman.ecom.domain.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private Long id;

    private String name;

    private int age;

    private String address;

    public static CustomerDto of(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .age(customer.getAge())
                .address(customer.getAddress())
                .build();
    }
}
