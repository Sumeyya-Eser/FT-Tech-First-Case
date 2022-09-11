package com.fttech.firstCase.repository;

import com.fttech.firstCase.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

       @Query(value = "SELECT * FROM product_comment p WHERE p.user_id =:userId", nativeQuery = true)
       List<ProductComment> findAllProductCommentByUser(Long userId);

       @Query(value = "SELECT * FROM product_comment p WHERE p.user_id =:userId AND p.comment_date BETWEEN :startDate AND :endDate", nativeQuery = true)
       List<ProductComment> findProductCommentsByUserIdBetweenTwoDates(Long userId, String startDate, String endDate);

       @Query(value = "SELECT * FROM product_comment p WHERE p.product_id =:productId AND p.comment_date BETWEEN :startDate AND :endDate", nativeQuery = true)
       List<ProductComment> findProductCommentsByProductIdBetweenTwoDates(Long productId, String startDate, String endDate);

       @Query(value = "SELECT * FROM product_comment p WHERE p.product_id =:productId", nativeQuery = true)
       List<ProductComment> findProductCommentsByProductId(Long productId);
}
