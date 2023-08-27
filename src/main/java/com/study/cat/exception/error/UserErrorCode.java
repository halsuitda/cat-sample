package com.study.cat.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeIfs{
    USER_NOT_FOUND(404, 14101, "사용자를 찾을 수 없음"),
    INACTIVE_USER(403, 14102, "비활성화 회원")
    ;

    private final Integer statusCode;

    private final Integer errorCode;

    private final String message;

}
