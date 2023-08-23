package com.study.cat.user.repository;

import com.study.cat.user.entity.User;

public interface UserRepository {

    User saveUser(User user);

    User findUserById(Long userId);

    User findUserByEmail(String email);

}
