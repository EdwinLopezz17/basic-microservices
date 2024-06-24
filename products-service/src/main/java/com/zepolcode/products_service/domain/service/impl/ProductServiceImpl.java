package com.zepolcode.products_service.domain.service.impl;

import com.zepolcode.products_service.domain.model.dto.ProductRequest;
import com.zepolcode.products_service.domain.model.dto.ProductResponse;
import com.zepolcode.products_service.domain.model.entities.Product;
import com.zepolcode.products_service.domain.service.ProductService;
import com.zepolcode.products_service.infrastructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = productRepository.save( new Product(productRequest));
        return new ProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

}
