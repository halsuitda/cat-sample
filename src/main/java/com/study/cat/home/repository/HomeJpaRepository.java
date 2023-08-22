package com.study.cat.home.repository;

import com.study.cat.home.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeJpaRepository extends JpaRepository<HomeEntity, Long> {
}
