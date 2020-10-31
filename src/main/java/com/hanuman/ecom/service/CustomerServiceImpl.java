package com.hanuman.ecom.service;

import com.hanuman.ecom.api.dto.CreateCustomerDto;
import com.hanuman.ecom.domain.Customer;
import com.hanuman.ecom.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers(String name, String sort, String order) {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(CreateCustomerDto customer) {
        Customer saveCustomer = new Customer();
        BeanUtils.copyProperties(customer, saveCustomer);
        return customerRepository.save(saveCustomer);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Customer not found with the id %s", id)));
    }
}
