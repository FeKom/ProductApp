package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.ProductModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, UUID> {
    @Query("SELECT p FROM ProductModel p WHERE p.tittle Like %:searchTerm%")
    Optional<List<ProductModel>> findByProductName(@Param("searchTerm")String searchTerm);
    
}
