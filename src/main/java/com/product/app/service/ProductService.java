package com.product.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.exceptions.SearchByNameException;
import jakarta.transaction.Transactional;
import com.product.app.model.ProductModel;
import com.product.app.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Transactional 
    public ProductModel save (ProductModel ProductModel) {

        return productRepo.save(ProductModel);
    }

    public List<ProductModel> findAll() {
        return productRepo.findAll();
    }

    public ProductModel findById(UUID productId) {
        return productRepo.findById(productId).get();
    }

    public Optional<List<ProductModel>> searchProductByName(String searchTerm) {

        if (searchTerm.isEmpty() || searchTerm.isBlank()) {
            throw new SearchByNameException();
        }else {
            return productRepo.findByProductName(searchTerm);
        }
        
    }


}
