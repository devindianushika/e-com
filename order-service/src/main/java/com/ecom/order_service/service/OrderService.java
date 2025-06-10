package com.ecom.order_service.service;

import com.ecom.order_service.entities.Order;
import com.ecom.order_service.entities.utils.CommonResponse;
import com.ecom.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderService(Order order){
        CommonResponse commonResponse = new CommonResponse();
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
