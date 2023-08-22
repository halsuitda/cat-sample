package com.study.cat.home.repository;

import com.study.cat.home.entity.HomeEntity;

public interface CustomHomeRepository {

    HomeEntity findHomeById(Long id);

    HomeEntity saveHome(HomeEntity home);

}
