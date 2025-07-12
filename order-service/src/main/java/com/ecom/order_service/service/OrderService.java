package com.ecom.order_service.service;

import com.ecom.order_service.client.ProductClient;
import com.ecom.order_service.dto.ProductDto;
import com.ecom.order_service.entities.Order;
import com.ecom.order_service.entities.utils.CommonResponse;
import com.ecom.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public CommonResponse createOrderService(Order order) {
        CommonResponse response = new CommonResponse();
        try {
            Order createdOrder = orderRepository.save(order);
            response.setStatus(1);
            response.setNarration("order created successfully orderId: " + createdOrder.getId());
        } catch (Exception exception) {
            response.setStatus(-1);
            response.setNarration("Order creation failed");
        }
        return response;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(long productId,int quantity){
        ProductDto product = productClient.getProductById(productId);
        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Not enough stock for product: " + product.getName());
        }
        else{
            Order order = new Order();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setTotalPrice(product.getPrice() * quantity);
            return orderRepository.save(order);
        }
    }
}
