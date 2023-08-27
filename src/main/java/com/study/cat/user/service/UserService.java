package com.study.cat.user.service;

import com.study.cat.user.entity.User;
import com.study.cat.user.repository.UserRepository;
import com.study.cat.user.repository.impl.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {



    private final UserRepository userRepository;



}
