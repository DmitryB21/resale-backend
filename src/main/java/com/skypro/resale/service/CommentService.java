package com.skypro.resale.service;

import com.skypro.resale.dto.CommentDto;
import com.skypro.resale.dto.CreateOrUpdateComment;
import org.springframework.security.core.Authentication;


import java.util.List;

public interface CommentService {
    CommentDto addComment(Integer id, CreateOrUpdateComment createOrUpdateComment);

    void deleteComment(Integer adId, Integer commentId);

    CommentDto updateComments(Integer adId, Integer commentId, CreateOrUpdateComment createOrUpdateComment);

    List<CommentDto> getComments(Integer id);

//    CommentDto getCommentById(Integer id);
}
