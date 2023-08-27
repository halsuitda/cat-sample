package com.study.cat.home.repository.impl;

import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.repository.HomeJpaRepository;
import com.study.cat.home.repository.CustomHomeRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CustomHomeRepositoryImpl implements CustomHomeRepository {

    private final HomeJpaRepository jpaRepository;

    @Override
    public HomeEntity findHomeById(Long id) {
        return jpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public HomeEntity saveHome(HomeEntity home) {
        return jpaRepository.save(home);
    }

}
