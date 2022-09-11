package com.fttech.firstCase.repository;

import com.fttech.firstCase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p  \n" +
            "   WHERE p.expiryDate < CURRENT_TIMESTAMP", nativeQuery = true)
    List<Product> findExpiredProducts();

    @Query(value = "SELECT * FROM product p     \n" +
            "    WHERE p.expiry_date > CURRENT_TIMESTAMP", nativeQuery = true)
    List<Product> findNotExpiredProducts();
}
