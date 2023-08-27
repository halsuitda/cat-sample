package com.study.cat.home.service;

import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.repository.CustomHomeRepository;

public class HomeService {

    private final CustomHomeRepository homeRepository;

    public HomeService (CustomHomeRepository customHomeRepository){
        this.homeRepository = customHomeRepository;
    }


    public HomeEntity createHome(String content) {

        HomeEntity home = HomeEntity.builder()
                .content(content)
                .build();
        return homeRepository.saveHome(home);
    }

    public HomeEntity findHome(Long id) {
        return homeRepository.findHomeById(id);
    }
}
