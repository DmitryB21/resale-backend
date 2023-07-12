package com.skypro.resale.mapper;

import com.skypro.resale.dto.AdDto;
import com.skypro.resale.dto.CreateOrUpdateAd;
import com.skypro.resale.dto.ExtendedAd;
import com.skypro.resale.model.Ad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface AdsMapper {

//    String ADS_IMAGE = "/ads/image/";
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "image", ignore = true)
    Ad toModel(CreateOrUpdateAd dto);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "author.id")
 //   @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    AdDto toDto(Ad ads);

    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    @Mapping(target = "phone", source = "author.phone")
    @Mapping(target = "email", source = "author.username")
    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    @Mapping(target = "pk", source = "id")
    ExtendedAd toExtendedAd(Ad ads);

//    @Named("imageMapping")
//    default String imageMapping(Image image) {
//        if (image == null) {
//            return null;
//        }
//        return ADS_IMAGE + image.getId();
//    }

}
