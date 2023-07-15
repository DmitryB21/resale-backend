package com.skypro.resale.service;

import com.skypro.resale.dto.AdDto;
import com.skypro.resale.dto.AdsDto;
import com.skypro.resale.dto.CreateOrUpdateAd;
import com.skypro.resale.dto.ExtendedAd;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface AdsService {
    AdsDto getAllAds();

    AdDto addAds(MultipartFile imageFiles, CreateOrUpdateAd createOrUpdateAd) throws IOException;

    ExtendedAd getAdsById(Integer id);

    void removeAdById(Integer id);

    AdDto updateAds(Integer id, CreateOrUpdateAd createOrUpdateAd);

    void updateImage(Integer id, MultipartFile imageFile) throws IOException;

    AdsDto getAdsMe(Authentication authentication);
}