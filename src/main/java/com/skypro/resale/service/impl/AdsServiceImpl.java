package com.skypro.resale.service.impl;

import com.skypro.resale.dto.AdsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdsServiceImpl {


    public List<AdsDto> getALLAds() {
        return new ArrayList<>();
    }
}
