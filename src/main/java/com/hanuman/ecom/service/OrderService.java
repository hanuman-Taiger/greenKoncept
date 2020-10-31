package com.hanuman.ecom.service;

import com.hanuman.ecom.api.dto.CreateOrderDto;
import com.hanuman.ecom.api.dto.OrderDto;
import com.hanuman.ecom.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();

    Order createOrder(CreateOrderDto order);
}
