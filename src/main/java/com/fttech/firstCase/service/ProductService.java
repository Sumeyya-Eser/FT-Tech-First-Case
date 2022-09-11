package com.fttech.firstCase.service;

import com.fttech.firstCase.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts(Optional<Long> productId);

    List<Product> findExpiredProducts();

    List<Product> findNotExpiredProducts();

    Product save(Product product);

    Product findProductById(Long productId);

    Product updateProductById(Long productId, Product updateProduct);

    void deleteProductById(Long productId);



}
