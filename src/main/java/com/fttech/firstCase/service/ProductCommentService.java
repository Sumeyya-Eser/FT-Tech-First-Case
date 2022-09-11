package com.fttech.firstCase.service;

import com.fttech.firstCase.entity.ProductComment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductCommentService {
    List<ProductComment> findAllProductComments(Optional<Long> productCommentId);

    ProductComment save(ProductComment productComment);

    ProductComment findProductCommentById(Long productCommentId);

    void deletePostById(Long productCommentId);

    List<ProductComment> findProductCommentsByUserId(Long userId);

    List<ProductComment> findProductCommentsByUserIdBetweenTwoDates(Long userId, String startDate, String endDate);

    List<ProductComment> findProductCommentsByProductIdBetweenTwoDates(Long productId, String startDate, String endDate);

    List<ProductComment> findProductCommentsByProductId(Long productId);
}
