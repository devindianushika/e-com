package com.ecom.product_server.Service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient ("PRODUCT-SERVER")
public interface ProductFeignService {

}
