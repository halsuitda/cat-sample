package com.study.cat.home.config;

import com.study.cat.home.repository.CustomHomeRepository;
import com.study.cat.home.repository.HomeJpaRepository;
import com.study.cat.home.repository.impl.CustomHomeRepositoryImpl;
import com.study.cat.home.repository.impl.CustomHomeRepositoryImplPro;
import com.study.cat.home.service.HomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HomeConfig {

    @Bean
    @Profile(value = "local")
    public HomeService homeService(CustomHomeRepository customHomeRepository) {
        System.out.println("### LOCAL BEEN");
        HomeService homeService = new HomeService(customHomeRepository);
        return homeService;
    }

    @Bean
    @Profile(value = "local")
    public CustomHomeRepository customHomeRepository(HomeJpaRepository jpaRepository) {
        return new CustomHomeRepositoryImpl(jpaRepository);
    }


    @Bean
    @Profile(value = "default")
    public HomeService homeService() {
        System.out.println("### DEFAULT BEEN");
        HomeService homeService = new HomeService(customHomeRepository());
        return homeService;
    }

    @Bean
    @Profile(value = "default")
    public CustomHomeRepository customHomeRepository() {
        return new CustomHomeRepositoryImplPro();
    }
}
