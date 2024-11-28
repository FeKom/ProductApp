package com.product.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.product.app.dtos.ProductDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.product.app.model.ProductModel;
import com.product.app.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    @Transactional
    public ResponseEntity<ProductModel> saveProduct (@Valid @RequestBody ProductDto productDto) {
        System.out.println(productDto);

        var ProductModel = new ProductModel();
        BeanUtils.copyProperties(productDto, ProductModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(ProductModel));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductModel>> getAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById (@PathVariable("id") UUID productId) {
        
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(productId));
    }

    @GetMapping("/product/search")
    public ResponseEntity<Optional<List<ProductModel>>> searchProductByName (@RequestParam String title) {

        return ResponseEntity.status(HttpStatus.OK).body(productService.searchProductByName(title));
    }
    
}