package com.study.cat.utils;

import com.study.cat.constant.LoginType;
import com.study.cat.user.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StubUtil {
    public UserResponseDto createUserResponseDto(Long userId) {
        return UserResponseDto
                .builder()
                .id(userId)
                .email("test@test.com")
                .nickName("Test User")
                .loginType(LoginType.KAKAO)
                .build();
    }
}
