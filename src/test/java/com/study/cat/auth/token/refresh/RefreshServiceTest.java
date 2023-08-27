package com.study.cat.auth.token.refresh;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class RefreshServiceTest {

    @Autowired
    private RefreshService service;

    @Test
    void test() {
        service.createRefresh("test@", "test");

        RefreshDto refresh = service.getRefresh("test@");
        Assertions.assertThat(refresh.getEmail()).isEqualTo("test@");
    }

}