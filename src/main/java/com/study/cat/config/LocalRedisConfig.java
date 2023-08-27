package com.study.cat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@RequiredArgsConstructor
@Slf4j
@Profile(value = "local")
public class LocalRedisConfig {


    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("### Local Redis");
        return new LettuceConnectionFactory("localhost", 6379);
    }

}