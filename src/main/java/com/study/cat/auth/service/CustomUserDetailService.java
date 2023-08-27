package com.study.cat.auth.service;

import com.study.cat.constant.UserStatus;
import com.study.cat.exception.ServiceLogicException;
import com.study.cat.exception.error.UserErrorCode;
import com.study.cat.user.entity.User;
import com.study.cat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser = userRepository.findUserByEmail(username);
        if (findUser.getUserStatus().equals(UserStatus.INACTIVE)) {
            throw new ServiceLogicException(UserErrorCode.INACTIVE_USER);
        }
        log.info("### CustomUserDetailService Login 인증에 필요한 User Database 조회 및 Password 검증");
        return new CustomUserDetail(findUser);
    }

    private static final class CustomUserDetail extends User implements UserDetails {
        public CustomUserDetail(User user) {
            setId(user.getId());
            setEmail(user.getEmail());
            setPassword(user.getPassword());
            setRoles(user.getRoles());
            setUserStatus(user.getUserStatus());
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }



}
