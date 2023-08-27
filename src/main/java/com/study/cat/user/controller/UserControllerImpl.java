package com.study.cat.user.controller;

import com.study.cat.dto.ResponseDto;
import com.study.cat.dto.Result;
import com.study.cat.user.dto.UserPatchDto;
import com.study.cat.user.dto.UserPostDto;
import com.study.cat.user.dto.UserResponseDto;
import com.study.cat.utils.StubUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Validated
public class UserControllerImpl implements UserControllerIfs {

    private final StubUtil stubUtil;


    // 회원 생성
    @PostMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> postUser(
            UserPostDto requestDto
    ) {
        //request Data -> UserService() -> UserResponseDto
        UserResponseDto testUser = stubUtil.createUserResponseDto(1L);
        Result result = Result.create();
        ResponseDto<UserResponseDto> response = ResponseDto.of(testUser, result);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    // 회원 조회
    @GetMapping("/{userId}")
    // 1번 회원의 정보 요청 http://naver.com/api/user/1
    public ResponseEntity<ResponseDto<UserResponseDto>> getUser(
            Long userId
    ) {
        UserResponseDto testUser = stubUtil.createUserResponseDto(userId);

        return ResponseEntity
                .ok(ResponseDto.of(testUser, Result.ok()));
    }


    // 회원 수정
    @PatchMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> patchUser(
            UserPatchDto userPatchDto
    ) {
        UserResponseDto testUser = stubUtil.createUserResponseDto(userPatchDto.getUserId());

        return ResponseEntity
                .ok(ResponseDto.of(testUser, Result.ok()));
    }

    // 회원 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(
            Long userId
    ) {
        // TODO 회원 삭제로직
        return ResponseEntity.noContent().build();
    }
}
