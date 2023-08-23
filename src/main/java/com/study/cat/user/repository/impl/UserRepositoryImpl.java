package com.study.cat.user.repository.impl;

import com.study.cat.exception.ServiceLogicException;
import com.study.cat.exception.error.UserErrorCode;
import com.study.cat.user.entity.User;
import com.study.cat.user.repository.UserJpaRepository;
import com.study.cat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public User saveUser(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) {
        return jpaRepository.findById(userId)
                .orElseThrow(() -> new ServiceLogicException(UserErrorCode.USER_NOT_FOUND));
    }

    @Override
    public User findUserByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .orElseThrow(() -> new ServiceLogicException(UserErrorCode.USER_NOT_FOUND));
    }
}
