package com.hanuman.ecom.api;

import com.hanuman.ecom.api.dto.CreateOrderDto;
import com.hanuman.ecom.api.dto.OrderDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/order")
public interface OrderApi {

    @GetMapping
    @ApiOperation(value = "Return all orders available in the System by sorting Customer Name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    ResponseEntity<List<OrderDto>> getAllOrders();

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Creates New Order In the System", response = OrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created Order"),
            @ApiResponse(code = 404, message = "Customer Not exit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderDto order);

}
