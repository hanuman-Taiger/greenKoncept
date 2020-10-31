package com.hanuman.ecom.controller;

import com.hanuman.ecom.api.CustomerApi;
import com.hanuman.ecom.api.dto.CreateCustomerDto;
import com.hanuman.ecom.api.dto.CustomerDto;
import com.hanuman.ecom.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class CustomerController implements CustomerApi {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<List<CustomerDto>> findAllCustomers(String name, String sort, String order) {
        LOGGER.info("==> Fetching All Customers  ");
        return ResponseEntity.ok().body(customerService.getAllCustomers(name, sort, order)
                .stream().map(CustomerDto::of).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CreateCustomerDto customer) {
        LOGGER.info("==> Creating Customer {} ", customer);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(CustomerDto.of(customerService.createCustomer(customer)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad data");
        }

    }
}
