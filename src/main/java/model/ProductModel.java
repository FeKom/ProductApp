package model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID productId;
private String tittle;
private double price;
private double review;

public String getTittle() {
    return tittle;
}
public void setTittle(String tittle) {
    this.tittle = tittle;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
public double getReview() {
    return review;
}
public void setReview(double review) {
    this.review = review;
}
public UUID getProductId() {
    return productId;
}
public void setProductId(UUID productId) {
    this.productId = productId;
}


}
