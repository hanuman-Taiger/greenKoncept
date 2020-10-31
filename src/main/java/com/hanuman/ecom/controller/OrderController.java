package com.hanuman.ecom.controller;

import com.hanuman.ecom.api.OrderApi;
import com.hanuman.ecom.api.dto.CreateOrderDto;
import com.hanuman.ecom.api.dto.OrderDto;
import com.hanuman.ecom.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController implements OrderApi {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        LOGGER.info("==> Fetching All Orders  ");
        return ResponseEntity.ok().body(orderService.findAllOrders().stream()
                .map(OrderDto::of).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<OrderDto> createOrder(CreateOrderDto order) {

        LOGGER.info("==> Creating order {}", order);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(OrderDto.of(orderService.createOrder(order)));
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
