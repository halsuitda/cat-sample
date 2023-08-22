package com.study.cat.home.controller;

import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findHome(
            @PathVariable Long id
    ) {
        HomeEntity home = homeService.findHome(id);
        return ResponseEntity.ok(home);
    }
}
