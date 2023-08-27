package com.study.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer status;

    private String message;

    public static Result ok() {
        return Result.builder()
                .status(HttpStatus.OK.value())
                .message("Success")
                .build();
    }

    public static Result create() {
        return Result.builder()
                .status(HttpStatus.CREATED.value())
                .message("Create")
                .build();
    }
}
