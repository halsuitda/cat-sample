package com.study.cat.auth.token.refresh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@Setter
// 1달 2592000 sec
@RedisHash(value = "Refresh", timeToLive = 2592000)
public class RefreshEntity {

    @Id
    private String email;

    private String refreshToken;

    private LocalDateTime createdAt;

    private RefreshEntity(String email, String refreshToken) {
        this.email = email;
        this.refreshToken = refreshToken;
        this.createdAt = LocalDateTime.now();
    }

    public static RefreshEntity of(String email, String refreshToken) {
        return new RefreshEntity(email, refreshToken);
    }
}
