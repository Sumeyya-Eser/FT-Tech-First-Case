package com.fttech.firstCase.service;

import com.fttech.firstCase.entity.Product;
import com.fttech.firstCase.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts(Optional<Long> productId) {
        if(productId.isPresent()){
            productRepository.findById(productId.get());
        }
        return productRepository.findAll();
    }

    @Override
    public List<Product> findExpiredProducts() {
        return productRepository.findExpiredProducts();
    }

    @Override
    public List<Product> findNotExpiredProducts() {
        return productRepository.findNotExpiredProducts();
    }

    @Override
    public Product save(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1 == null){
            return null;
        }
        Product productToSave = new Product();
        productToSave.setId(product.getId());
        productToSave.setName(product.getName());
        productToSave.setPrice(product.getPrice());
        productToSave.setExpiryDate(product.getExpiryDate());


        return productRepository.save(productToSave);
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateProductById(Long productId, Product updateProduct) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            Product productToUpdate = product.get();
            productToUpdate.setName(updateProduct.getName());
            productToUpdate.setPrice(updateProduct.getPrice());
            productToUpdate.setExpiryDate(updateProduct.getExpiryDate());
            productRepository.save(productToUpdate);

            return productToUpdate;
        }
        return null;
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
