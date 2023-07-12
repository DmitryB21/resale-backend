package com.skypro.resale.service.impl;

import com.skypro.resale.dto.*;
import com.skypro.resale.mapper.AdsMapper;
import com.skypro.resale.model.Ad;
import com.skypro.resale.model.Image;
import com.skypro.resale.repository.AdRepository;
import com.skypro.resale.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdRepository adRepository;
    private final ImageServiceImpl imageService;


    public List<AdDto> getAllAds() {
        return adRepository.findAll().stream()
                .map(ad -> AdsMapper.INSTANCE.toDto(ad))
                .collect(Collectors.toList());
    }

    public AdDto addAds(MultipartFile image, CreateOrUpdateAd createOrUpdateAd) throws IOException {
        Ad ad = AdsMapper.INSTANCE.toModel(createOrUpdateAd);
//        User user = userService.getUserByUsername(authentication.getName());
//        ad.setAuthor(user);
        Image imageUpload = imageService.uploadImage(image);
        ad.setImage(imageUpload);
        return AdsMapper.INSTANCE.toDto(adRepository.save(ad));
    }

    public ExtendedAd getAdsById(Integer id) {
        return new ExtendedAd();
    }

    public void removeAdById(Integer id) {
//        Ads ads = findAdsById(id);
//        adsRepository.delete(ads);
    }


    public AdsDto updateAds(Integer id, CreateOrUpdateAd createAds) {

//        if (createAds.getTitle() == null || createAds.getTitle().isBlank()
//                || createAds.getDescription() == null || createAds.getDescription().isBlank()
//                || createAds.getPrice() == null) throw new IncorrectArgumentException();

//        Ads ads = findAdsById(id);
//        ads.setTitle(createAds.getTitle());
//        ads.setDescription(createAds.getDescription());
//        ads.setPrice(createAds.getPrice());
//        adsRepository.save(ads);
//        log.info("Ads details updated for ads: {}", ads.getTitle());
//        return AdsMapper.INSTANCE.toDto(ads);
        return new AdsDto();
    }

    public void updateImage(Integer id, MultipartFile imageFile) throws IOException {
//        Ads ads = findAdsById(id);
//        if (ads.getImage() != null) {
//            imageService.remove(ads.getImage());
//        }
//        ads.setImage(imageService.uploadImage(imageFile));
//        adsRepository.save(ads);
    }



    public List<CommentDto> getComments(Integer id) {
        return new ArrayList<>();
    }

    public CommentDto addComment(Integer id, CommentDto newCommentDto) {
        return new CommentDto();
    }

    public List<AdsDto> getAdsMe() {
//        return adsRepository.
//                findAllByAuthorId(userService.getUserByUsername(authentication.getName()).getId())
//                .stream()
//                .map(AdsMapper.INSTANCE::toDto)
//                .collect(Collectors.toList());
        return new ArrayList<>();
    }


}
