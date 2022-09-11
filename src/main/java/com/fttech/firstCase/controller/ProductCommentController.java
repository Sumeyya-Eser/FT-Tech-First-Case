package com.fttech.firstCase.controller;

import com.fttech.firstCase.entity.ProductComment;
import com.fttech.firstCase.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productComments")
@RequiredArgsConstructor
public class ProductCommentController {
    @Autowired
    ProductCommentService productCommentService;

    @GetMapping
    public List<ProductComment> getAllProductComments(@RequestParam Optional<Long> productCommentId){
        return productCommentService.findAllProductComments(productCommentId);
    }


    @PostMapping
    public ProductComment saveProductComment(@RequestBody ProductComment productComment){
        return productCommentService.save(productComment);

    }

    @GetMapping("/{productCommentId}")
    public ProductComment getProductCommentById(@PathVariable Long productCommentId){
        return productCommentService.findProductCommentById(productCommentId);
    }

    @GetMapping("/ProductCommentsByUserId/{userId}")
    public List<ProductComment> getProductCommentsByUserId(@PathVariable Long userId){
        return productCommentService.findProductCommentsByUserId(userId);
    }

    @GetMapping("/ProductCommentsByUserId/{productId}")
    public List<ProductComment> getProductCommentsByProductId(@PathVariable Long productId){
        return productCommentService.findProductCommentsByProductId(productId);
    }

    @GetMapping("/ProductCommentsByUserIdBetweenTwoDates/{userId}/{startDate}/{endDate}")
    public List<ProductComment> getProductCommentsByUserIdBetweenTwoDates(@PathVariable Long userId,
                                                                          @PathVariable String startDate,
                                                                          @PathVariable String endDate){
        return productCommentService.findProductCommentsByUserIdBetweenTwoDates(userId, startDate, endDate);
    }

    @GetMapping("/ProductCommentsByProductIdBetweenTwoDates/{productId}/{startDate}/{endDate}")
    public List<ProductComment> getProductCommentsByProductIdBetweenTwoDates(@PathVariable Long productId,
                                                                          @PathVariable String startDate,
                                                                          @PathVariable String endDate){
        return productCommentService.findProductCommentsByProductIdBetweenTwoDates(productId, startDate, endDate);
    }

    @DeleteMapping("/{productCommentId}")
    public void deleteProductCommentById(@PathVariable Long productCommentId){
        productCommentService.deletePostById(productCommentId);
    }


}
