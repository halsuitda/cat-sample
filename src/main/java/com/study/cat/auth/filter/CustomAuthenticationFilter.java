package com.study.cat.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.cat.auth.dto.LoginDto;
import com.study.cat.exception.ServiceLogicException;
import com.study.cat.exception.error.AuthErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            LoginDto loginDto = mapper.readValue(request.getInputStream(), LoginDto.class);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
            log.info("### JwtAuthenticationFilter Login 인증 객체 생성");
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (IOException e) {
            throw new ServiceLogicException(AuthErrorCode.LOGIN_BAD_REQUEST);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult
    ) throws IOException, ServletException {
        /*
        * attemptAuthentication -> UserDetailsService -> 인증 완료 -> successfulAuthentication
        * */
        log.info("### JwtAuthenticationFilter Login 인증 완료");
        this.getSuccessHandler().onAuthenticationSuccess(request, response, chain, authResult);
    }
}

