package com.study.cat.home.config;

import com.study.cat.home.repository.CustomHomeRepository;
import com.study.cat.home.repository.HomeJpaRepository;
import com.study.cat.home.repository.impl.CustomHomeRepositoryImpl;
import com.study.cat.home.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HomeConfig {

    @Bean
    public HomeService homeService(CustomHomeRepository customHomeRepository) {
        HomeService homeService = new HomeService(customHomeRepository);
        return homeService;
    }

    @Bean
    public CustomHomeRepository customHomeRepository(HomeJpaRepository jpaRepository) {
        return new CustomHomeRepositoryImpl(jpaRepository);
    }

}
