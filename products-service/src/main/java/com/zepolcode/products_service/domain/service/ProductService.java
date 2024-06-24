package com.zepolcode.products_service.domain.service;


import com.zepolcode.products_service.domain.model.dto.ProductRequest;
import com.zepolcode.products_service.domain.model.dto.ProductResponse;
import com.zepolcode.products_service.domain.model.entities.Product;

import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
