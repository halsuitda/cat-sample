package com.study.cat.user.controller;

import com.study.cat.exception.ServiceLogicException;
import com.study.cat.exception.error.UserErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public ResponseEntity<?> test() {
        throw new ServiceLogicException(UserErrorCode.USER_NOT_FOUND);
    }
}
