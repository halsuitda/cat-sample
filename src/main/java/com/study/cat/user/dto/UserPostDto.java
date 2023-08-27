package com.study.cat.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Schema(description = "회원 생성 요청 Body")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDto {

    @Schema(description = "회원 Email", example = "test@test.com")
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "정확한 이메일을 입력해 주세요.")
    @NotBlank(message = "이메일 필수 입력 값입니다.")
    private String email;

    @Schema(description = "회원 비밀번호", example = "aaaa1111!")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    @Schema(description = "회원 닉네임", example = "TestUser")
    @NotBlank(message = "닉네임 필수 입력 값입니다.")
    private String nickName;

}
