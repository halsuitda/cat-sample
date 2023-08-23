package com.study.cat.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "고파사 API 명세",
                description = "고파사 프로젝트 백엔드 서버 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi catOpenApi() {
        String[] paths = {"/api/**"};

        return GroupedOpenApi.builder()
                .group("고파사 API v1")
                .pathsToMatch(paths)
                .build();
    }
}
