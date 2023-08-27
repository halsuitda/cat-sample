package com.study.cat.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeIfs{

    BAD_REQUEST(404, 14001, "Not Found"),
    NOT_FOUND(404, 14002, "Not Found"),
    ARGUMENT_MISMATCH_BAD_REQUEST(400, 14002, "잘못된 파라미터"),
    DATA_ACCESS_ERROR(500, 15001, "Database Access 에러"),
    INTERNAL_SERVER_ERROR(500, 15002, "서버 에러")
    ;

    private final Integer statusCode;

    private final Integer errorCode;

    private final String message;
}
