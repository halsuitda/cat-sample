package com.study.cat.home.service;

import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.repository.CustomHomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final CustomHomeRepository homeRepository;

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
