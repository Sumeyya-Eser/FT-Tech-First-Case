package com.fttech.firstCase.service;

import com.fttech.firstCase.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User findUserById(Long userId);

    User updateUserById(Long userId, User newUser);

    void deleteUserById(Long userId);
}
