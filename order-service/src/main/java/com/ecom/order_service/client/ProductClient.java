package com.ecom.order_service.client;

import com.ecom.order_service.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient ("product-service")
public interface ProductClient {

    @GetMapping ("/products/{id}")
    ProductDto getProductById(@PathVariable ("id") Long id);

}
