package com.study.cat.user.controller;

import com.study.cat.dto.ResponseDto;
import com.study.cat.exception.dto.ErrorResponse;
import com.study.cat.user.dto.UserPatchDto;
import com.study.cat.user.dto.UserPostDto;
import com.study.cat.user.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Tag(name = "User", description = "회원 도메인 API")
public interface UserControllerIfs {

    @Operation(summary = "회원 생성 요청", description = "이메일 회원 생성 요청 API.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원 생성 완료"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<ResponseDto<UserResponseDto>> postUser(@Valid @RequestBody UserPostDto requestDto);

    @Operation(summary = "단건 회원 조회", description = "단건 회원 정보 요청 API.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<ResponseDto<UserResponseDto>> getUser(
            @Parameter(name = "userId", description = "회원의 식별자", in = ParameterIn.PATH)
            @Positive @PathVariable("userId") Long userId
    );

    @Operation(summary = "회원 정보 수정", description = "특정 회원 정보 수정 요청 API.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity<ResponseDto<UserResponseDto>> patchUser(
            @Valid @RequestBody UserPatchDto userPatchDto
    );

    @Operation(summary = "회원 비활성화", description = "특정 회원 비활성화 요청 API.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "회원 비활성화 완료",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    ResponseEntity deleteUser(
            @Parameter(name = "userId", description = "회원의 식별자", in = ParameterIn.PATH)
            @Positive @PathVariable("userId") Long userId
    );
}
