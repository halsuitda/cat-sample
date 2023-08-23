package com.study.cat.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeIfs{

    ARGUMENT_MISMATCH_BAD_REQUEST(400, 14001, "잘못된 파라미터"),
    INTERNAL_SERVER_ERROR(500, 15001, "서버 에러")
    ;

    private final Integer statusCode;

    private final Integer errorCode;

    private final String message;
}
