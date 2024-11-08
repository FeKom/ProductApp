package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.ProductModel;
import repository.ProductRepo;

@Service
public class ProductService {

@Autowired
ProductRepo productRepo;

@Transactional 
public ProductModel save (ProductModel ProductModel) {

    return productRepo.save(ProductModel);
}
    
}
