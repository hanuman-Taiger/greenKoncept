package com.hanuman.ecom.service;


import com.hanuman.ecom.api.dto.CreateOrderDto;
import com.hanuman.ecom.domain.Customer;
import com.hanuman.ecom.domain.Order;
import com.hanuman.ecom.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderReporsitory;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Order> findAllOrders() {
        return (List<Order>) orderReporsitory.getOrderInfo();
    }

    @Override
    public Order createOrder(CreateOrderDto order) {
        Customer customer = customerService.getCustomerById(order.getCustId());
        Order saveOrder = new Order();
        BeanUtils.copyProperties(order, saveOrder);
        saveOrder.setOrderTime(new Timestamp(new Date().getTime()));
        saveOrder.setCustomer(customer);
        return orderReporsitory.save(saveOrder);
    }
}
