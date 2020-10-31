package com.hanuman.ecom.service;

import com.hanuman.ecom.api.dto.CreateCustomerDto;
import com.hanuman.ecom.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers(String name, String sort, String order);

    Customer createCustomer(CreateCustomerDto customer);

    Customer getCustomerById(long id);
}
