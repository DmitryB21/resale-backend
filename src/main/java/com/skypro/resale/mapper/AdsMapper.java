package com.skypro.resale.mapper;

import com.skypro.resale.dto.AdDto;
import com.skypro.resale.dto.AdsDto;
import com.skypro.resale.dto.CreateOrUpdateAd;
import com.skypro.resale.dto.ExtendedAd;
import com.skypro.resale.model.Ad;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdsMapper {

//    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "image", ignore = true)
    Ad toModel(CreateOrUpdateAd dto);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "author.id")
 //   @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    AdDto toDto(Ad ad);

    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    @Mapping(target = "phone", source = "author.phone")
    @Mapping(target = "email", source = "author.username")
    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    @Mapping(target = "pk", source = "id")
    ExtendedAd toExtendedAd(Ad ad);

//    @Named("imageMapping")
//    default String imageMapping(Image image) {
//        if (image == null) {
//            return null;
//        }
//        return ADS_IMAGE + image.getId();
//    }

    /**
     * adsListToResponseWrapperAdsDto(Integer sizeList, List<Ad> entityList):
     * Этот метод отображает список объектов типа Ad на объект типа AllAdsOfUserDto,
     * который представляет обертку для списка объявлений пользователя.
     * Он также выполняет отображение поля sizeList на поле count и полей entityList на поле results.
     */
    @Mapping(source = "sizeList", target = "count")
    @Mapping(source = "entityList", target = "results")
    AdsDto adListToAdsDto(Integer sizeList, List<Ad> list);

    /**
     * adsListToAdsDtoList(List<Ad> adsList):
     * Этот метод принимает список объектов типа Ad и отображает каждый объект на объект типа AdsDto.
     * В результате возвращается список объектов типа AdsDto.
     */
    List<AdDto> adListToAdDtoList(List<Ad> adsList);

}
