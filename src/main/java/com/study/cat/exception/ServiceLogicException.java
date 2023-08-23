package com.study.cat.exception;

import com.study.cat.exception.error.ErrorCodeIfs;
import lombok.Getter;

@Getter
public class ServiceLogicException extends RuntimeException{

    private ErrorCodeIfs errorCode;

    public ServiceLogicException(ErrorCodeIfs errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
