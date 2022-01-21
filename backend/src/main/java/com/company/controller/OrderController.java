package com.company.controller;

import com.company.dto.OrderDto;
import com.company.entity.Order;
import com.company.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPath.ROOT + ApiPath.ORDER)
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }

    @ApiOperation(value = "Get all orders", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "received orders"),
            @ApiResponse(code = 403, message = "you do not have permisiions"),
            @ApiResponse(code = 401, message = "not connected")
    })
    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

}
