package com.study.cat.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCodeIfs{

    LOGIN_BAD_REQUEST(400, 14201, "잘못된 로그인 요청"),
    ACCESS_DENIED(403, 14202, "접근 거부"),
    EXPIRED_ACCESS_TOKEN(403, 14204, "Access Token 만료"),
    EXPIRED_REFRESH_TOKEN(403, 14205, "Refresh Token 만료"),
    TOKEN_NOT_NULL(404, 14206, "요청 Token Null Value")
    ;

    private final Integer statusCode;

    private final Integer errorCode;

    private final String message;
}
