package com.study.cat.exception.dto;

import com.study.cat.exception.error.ErrorCodeIfs;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {

    @Schema(description = "Error Status Code", example = "4XX or 5XX")
    private int status;

    @Schema(description = "Error Message", example = "Not Found User")
    private String message;

    @Schema(description = "BackEnd Server Error Code", example = "14xxx or 15xxx")
    private int code;

    @Schema(description = "Field Error Info")
    private List<FieldError> fieldErrors;

    @Schema(description = "Parameter & Body Validation Error Info")
    private List<ConstraintViolationError> violationErrors;

    private ErrorResponse(int status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private ErrorResponse(List<FieldError> fieldErrors,
                          List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
    }

    public static ErrorResponse of(ErrorCodeIfs errorCode) {
        return new ErrorResponse(errorCode.getStatusCode(), errorCode.getMessage(), errorCode.getErrorCode());
    }

    public static ErrorResponse of(HttpStatus status) {
        return new ErrorResponse(status.value(), status.getReasonPhrase());
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message) {
        return new ErrorResponse(httpStatus.value(), message);
    }

    @Getter
    private static class FieldError {
        @Schema(description = "Field")
        private String field;
        @Schema(description = "요청 값")
        private Object rejectedValue;
        @Schema(description = "Error Message")
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            List<org.springframework.validation.FieldError> fieldErrorList =
                    bindingResult.getFieldErrors();
            return fieldErrorList.stream()
                    .map(error ->
                            new FieldError(
                                    error.getField(),
                                    error.getRejectedValue() == null ?
                                            "" : error.getRejectedValue().toString(),
                                    error.getDefaultMessage()
                            )).collect(Collectors.toList());
        }
    }

    @Getter
    private static class ConstraintViolationError {
        @Schema(description = "Property Path")
        private String propertyPath;
        @Schema(description = "요청 값")
        private Object rejectedValue;
        @Schema(description = "Error Message")
        private String reason;

        private ConstraintViolationError(String propertyPath,
                                         Object rejectedValue,
                                         String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations
        ) {
            return constraintViolations.stream()
                    .map(constraintViolation ->
                            new ConstraintViolationError(
                                    constraintViolation.getPropertyPath().toString(),
                                    constraintViolation.getInvalidValue().toString(),
                                    constraintViolation.getMessage()
                            )).collect(Collectors.toList());
        }
    }
}
