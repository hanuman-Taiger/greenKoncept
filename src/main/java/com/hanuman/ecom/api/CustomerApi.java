package com.hanuman.ecom.api;

import com.hanuman.ecom.api.dto.CreateCustomerDto;
import com.hanuman.ecom.api.dto.CustomerDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/customer")
public interface CustomerApi {

    @GetMapping
    ResponseEntity<List<CustomerDto>> findAllCustomers(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "sort", required = false) String sort,
                                                      @RequestParam(name = "sortOrder", required = false) String order);


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Creates New Order In the System", response = CustomerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created Customer"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CreateCustomerDto customer);

}
