package com.study.cat.home.controller;

import com.study.cat.dto.ResponseDto;
import com.study.cat.dto.Result;
import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String homeRedirect() {
        return "redirect:/swagger-ui.html";
    }

    private final HomeService homeService;
//
//
//    @Operation(summary = "GET HOME", description = "Home 데이터 조회.", tags = { "Home Controller" })
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "OK",
//                    content = @Content(schema = @Schema(implementation = ResponseDto.class))),
//            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
//            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
//    })
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findHome(
//            @PathVariable("id") Long id
//    ) {
//        HomeEntity home = homeService.findHome(id);
//        ResponseDto<HomeEntity> of = ResponseDto.of(home, Result.ok());
//        return ResponseEntity.ok(of);
//    }
//
//
//    @Operation(summary = "POST HOME", description = "Home 생성.", tags = { "Home Controller" })
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "OK",
//                    content = @Content(schema = @Schema(implementation = HomeEntity.class))),
//            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
//            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
//    })
//    @PostMapping("/register")
//    public ResponseEntity<?> registerHome(
//            @RequestParam String content
//    ) {
//        HomeEntity home = homeService.createHome(content);
//        return ResponseEntity.ok(home);
//    }
}
