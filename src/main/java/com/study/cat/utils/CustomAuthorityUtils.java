package com.study.cat.utils;

import com.study.cat.constant.Membership;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthorityUtils {

    public static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    public static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    public static final List<GrantedAuthority> BASIC_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_BASIC");
    public static final List<GrantedAuthority> PREMIUM_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_PREMIUM");

    public static final List<String> USER_ROLES_CALL_STRING = List.of("USER");
    public static final List<String> ADMIN_ROLES_CALL_STRING = List.of("ADMIN", "USER");
    public static final List<String> BASIC_ROLES_CALL_STRING = List.of("USER", "BASIC");
    public static final List<String> PREMIUM_ROLES_CALL_STRING = List.of( "USER", "PREMIUM");

    private final List<String> USER_ROLES_STRING = List.of("USER");
    private final List<String> ADMIN_ROLES_STRING = List.of("ADMIN", "USER");
    public final List<String> BASIC_ROLES_STRING = List.of("USER", "BASIC");
    public final List<String> PREMIUM_ROLES_STRING = List.of( "USER", "PREMIUM");




    /* 권한 부여 메소드 */
    public static List<GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> result =  roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toList());
        return result;
    }

    /* 권한 String 생성 메소드 */
    public static List<String> createRoles(Membership membership) {
        if (Membership.PREMIUM.equals(membership)) {
            return PREMIUM_ROLES_CALL_STRING;
        } else if (Membership.BASIC.equals(membership)) {
            return BASIC_ROLES_CALL_STRING;
        } else if (Membership.ADMIN.equals(membership)) {
            return ADMIN_ROLES_CALL_STRING;
        } else {
            return USER_ROLES_CALL_STRING;
        }
    }

}
