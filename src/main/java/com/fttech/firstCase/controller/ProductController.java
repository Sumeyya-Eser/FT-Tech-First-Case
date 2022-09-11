package com.fttech.firstCase.controller;

import com.fttech.firstCase.entity.Product;
import com.fttech.firstCase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/AllProducts")
    public List<Product> getAllProducts(@RequestParam Optional<Long> productId){
        return productService.findAllProducts(productId);
    }

    @GetMapping("/ExpiredProducts")
    public List<Product> getExpiredProducts(){
        return productService.findExpiredProducts();
    }

    @GetMapping("/NotExpiredProducts")
    public List<Product> getNotExpiredProducts(){
        return productService.findNotExpiredProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);

    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId){
        return productService.findProductById(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updateProduct){
        return productService.updateProductById(productId, updateProduct);
    }

    @DeleteMapping("/{userId}")
    public void deleteProductById(@PathVariable Long productId){
        productService.deleteProductById(productId);
    }
}
