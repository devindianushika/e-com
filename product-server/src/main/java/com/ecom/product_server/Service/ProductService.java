package com.ecom.product_server.Service;

import com.ecom.product_server.Entities.Product;
import com.ecom.product_server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProductService(Product productRequest){
       return productRepository.save(productRequest);
    }
    public Product getProductById(long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
