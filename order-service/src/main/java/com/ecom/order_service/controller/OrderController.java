package com.ecom.order_service.controller;


import com.ecom.order_service.dto.OrderRequestDto;
import com.ecom.order_service.entities.Order;
import com.ecom.order_service.entities.utils.CommonResponse;
import com.ecom.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/manualOrder")
    public CommonResponse createOrder(@RequestBody Order order){
        return orderService.createOrderService(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody OrderRequestDto orderRequest){
        return orderService.placeOrder(orderRequest.getProductId(), orderRequest.getQuantity());
    }

}
