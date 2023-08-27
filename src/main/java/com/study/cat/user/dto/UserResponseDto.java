package com.study.cat.user.dto;

import com.study.cat.constant.LoginType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "회원 응답 Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    @Schema(description = "회원 식별자")
    private Long id;

    @Schema(description = "회원 Email")
    private String email;

    @Schema(description = "회원 닉네임")
    private String nickName;

    @Schema(description = "회원 로그인 타입")
    private LoginType loginType;

}
