package com.zepolcode.products_service.application;

import com.zepolcode.products_service.domain.model.dto.ProductRequest;
import com.zepolcode.products_service.domain.model.dto.ProductResponse;
import com.zepolcode.products_service.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v5/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {

        ProductResponse productResponse = productService.addProduct(productRequest);

        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts() {
        return productService.getAllProducts();
    }


}
