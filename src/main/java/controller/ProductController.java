package controller;

import org.springframework.web.bind.annotation.RestController;

import dtos.ProductDto;
import jakarta.validation.Valid;
import model.ProductModel;
import service.ProductService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

@Autowired
ProductService productService;

@PostMapping("/product")
public ResponseEntity<ProductModel> saveProduct (@RequestBody @Valid ProductDto productDto) {
    var ProductModel = new ProductModel();
    BeanUtils.copyProperties(productDto, ProductModel);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(ProductModel));
}

    
}
