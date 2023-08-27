package com.study.cat.auth.token;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Token {

    private String accessToken;

    private String refreshToken;

}
