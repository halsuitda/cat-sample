package com.study.cat.auth.token.refresh;

import com.study.cat.exception.ServiceLogicException;
import com.study.cat.exception.error.AuthErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefreshService {

    private final RefreshRepository refreshRepository;

    public RefreshDto createRefresh(String email, String refreshToken) {
        RefreshEntity entity = RefreshEntity.of(email, refreshToken);
        return RefreshDto.of(refreshRepository.save(entity));
    }

    public RefreshDto getRefresh(String email) {
        RefreshEntity entity = refreshRepository.findById(email)
                .orElseThrow(() -> new ServiceLogicException(AuthErrorCode.EXPIRED_REFRESH_TOKEN));
        return RefreshDto.of(entity);
    }

    public void deleteRefresh(String email) {
        refreshRepository.deleteById(email);
    }

    public List<RefreshDto> getAll() {
        ArrayList<RefreshEntity> list = new ArrayList<>();
        refreshRepository.findAll().forEach(list::add);
        return list.stream().map(RefreshDto::of)
                .collect(Collectors.toList());
    }
}