package com.skypro.resale.mapper;

import com.skypro.resale.dto.CommentDto;
import com.skypro.resale.model.Avatar;
import com.skypro.resale.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring")
public interface AdsCommentMapper {

    String USER_AVATAR = "/users/avatar/";
    AdsCommentMapper INSTANSE = Mappers.getMapper(AdsCommentMapper.class);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "id", source = "pk")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "ads", ignore = true)
    Comment toEntity(CommentDto dto);

    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorImage", source = "author.avatar", qualifiedByName = "avatarMapping")
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    CommentDto toDto(Comment entity);

//    @Named("avatarMapping")
//    default String avatarMapping(Avatar avatar) {
//        if (avatar == null) {
//            return null;
//        }
//        return USER_AVATAR + avatar.getId();
//    }

}
