package com.study.cat.auth.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CorsFilter extends OncePerRequestFilter {
    /*
    * Filter의 개념
    * Controller로 들어오는 요청들을 말 그대로 Filtering 한다 생각하면 됨
    * OncePerRequestFilter 인터페이스는 하나의 요청에 한번 동작하는 Filter
    * */
    @Override
    protected void doFilterInternal(
            // 클라이언트 요청에 대한 데이터들을 가지고 있는 객체
            // 쿠키, 세션, 헤더, 바디 등등
            HttpServletRequest request,
            // 서버에서 응답 해줄 데이터들을 가지고 있는 객체
            // 서버에서 설정한 쿠키, 세션, 헤더, 바디 등등
            // 현재는 Filter 내부에 있으니 설정된 값은 아무것도 없고 default 값만 존재.
            HttpServletResponse response,
            // Filter Cahin은 Filter들의 집합
            // Filter 들의 적용 순서 등 다양한 방식으로 구현 가능
            FilterChain filterChain
    ) throws ServletException, IOException {
        log.info("Do CORS Filter");
        List<String> list = List.of(
                "http://localhost:3000"
        );
        String originUrl = request.getHeader("Origin");
        log.info("requestURL = {}", originUrl);
        String origin = list.stream().filter(
                o -> o.equals(originUrl)
        ).findFirst().orElse(originUrl);
        /* 현재 요청한 Origin에 대해서 그대로 Access-Control-Allow-Origin 헤더를 설정 해 주고 있기에
        *   모든 요청에 대해 Allow Origin 해주고 있는 것과 마찬가지다. */
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods","GET, POST, DELETE, PATCH, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "Authorization, userId, userStatus");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Key, Authorization, Authorization, userId, userStatus");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
