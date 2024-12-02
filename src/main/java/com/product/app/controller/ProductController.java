package com.product.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.product.app.dtos.ProductDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.product.app.model.ProductModel;
import com.product.app.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    @Operation(description = "Create a product")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Return a created product"),
        @ApiResponse(responseCode = "400", description = "Invalid post sintax"),
    })
    @Transactional
    public ResponseEntity<ProductModel> saveProduct (@Valid @RequestBody ProductDto productDto) {
        System.out.println(productDto);

        var ProductModel = new ProductModel();
        BeanUtils.copyProperties(productDto, ProductModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(ProductModel));
    }

    @GetMapping("/product")
    @Operation(description = "Get all products")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Return a list of all products"),
        @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    public ResponseEntity<List<ProductModel>> getAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/product/{id}")
    @Operation(description = "Get a product by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Return a product by ID"),
        @ApiResponse(responseCode = "404", description = "Invalid ID, or ID inexistent")
    })
    public ResponseEntity<ProductModel> getProductById (@PathVariable("id") UUID productId) {
        
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(productId));
    }

    @GetMapping("/product/search/{searchTerm}")
    @Operation(description = "Get a product by a search name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Return a List of all products with a searchTerm title"),
        @ApiResponse(responseCode = "404", description = "There are no products with that searchTerm")
    })
    public ResponseEntity<Optional<List<ProductModel>>> searchProductByName (@PathVariable("searchTerm") String title) {
        
        var product = productService.searchProductByName(title);

        if(!product.isEmpty()){
            return ResponseEntity.status(404).body(product);            
        }else {
            return ResponseEntity.status(200).body(product);
        }
    };
    
};
