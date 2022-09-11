package com.fttech.firstCase.service;

import com.fttech.firstCase.entity.Product;
import com.fttech.firstCase.entity.ProductComment;
import com.fttech.firstCase.entity.User;
import com.fttech.firstCase.repository.ProductCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{

    @Autowired
    private final ProductCommentRepository productCommentRepository;
    @Autowired
    private final ProductService productService;
    @Autowired
    private final UserService userService;

    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository,
                                     ProductService productService,
                                     UserService userService) {
        this.productCommentRepository = productCommentRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public List<ProductComment> findAllProductComments(Optional<Long> productCommentId) {
        if(productCommentId.isPresent()){
            productCommentRepository.findById(productCommentId.get());
        }

        return productCommentRepository.findAll();
    }

    @Override
    public ProductComment save(ProductComment productComment) {
        Product product = productService.findProductById(productComment.getProduct().getId());
        User user = userService.findUserById(productComment.getUser().getId());
        if(product != null && user != null){

            ProductComment productCommentToSave = new ProductComment();
            productCommentToSave.setComment(productComment.getComment());
            productCommentToSave.setUser(user);
            productCommentToSave.setProduct(product);
            return  productCommentRepository.save(productCommentToSave);

        }
        return null;
    }

    @Override
    public ProductComment findProductCommentById(Long productCommentId) {
        return productCommentRepository.findById(productCommentId).orElse(null);
    }

    @Override
    public void deletePostById(Long productCommentId) {
        productCommentRepository.deleteById(productCommentId);
    }

    @Override
    public List<ProductComment> findProductCommentsByUserId(Long userId) {
        List<ProductComment> productComments = productCommentRepository.findAllProductCommentByUser(userId);

        return productComments;
    }
    @Override
    public List<ProductComment> findProductCommentsByProductId(Long productId) {
        List<ProductComment> productComments = productCommentRepository.findProductCommentsByProductId(productId);

        return productComments;
    }
    @Override
    public List<ProductComment> findProductCommentsByUserIdBetweenTwoDates(Long userId, String startDate, String endDate) {
        List<ProductComment> productComments = productCommentRepository.findProductCommentsByUserIdBetweenTwoDates(userId, startDate, endDate);

        return productComments;
    }

    @Override
    public List<ProductComment> findProductCommentsByProductIdBetweenTwoDates(Long productId, String startDate, String endDate) {
        List<ProductComment> productComments = productCommentRepository.findProductCommentsByProductIdBetweenTwoDates(productId, startDate, endDate);

        return null;
    }


}
