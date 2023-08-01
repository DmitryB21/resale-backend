package com.skypro.resale.service.impl;

import com.skypro.resale.dto.CommentDto;
import com.skypro.resale.dto.CommentsDto;
import com.skypro.resale.dto.CreateOrUpdateComment;
import com.skypro.resale.mapper.AdsCommentMapper;
import com.skypro.resale.model.Ad;
import com.skypro.resale.model.Comment;
import com.skypro.resale.model.User;
import com.skypro.resale.repository.CommentRepository;
import com.skypro.resale.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
//    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    private final AdsServiceImpl adsService;
    private final CommentRepository commentRepository;
    private final AdsCommentMapper adsCommentMapper;

    @Override
    public CommentsDto getComments(Integer id) {
         List<Comment> commentList = commentRepository.findAll();
        Integer sizeList = commentList.size();
        return adsCommentMapper.commentListToCommentsDto(sizeList, commentList);
    }

    @Override
    public CommentDto addComment(Integer id, CreateOrUpdateComment createOrUpdateComment) {

        if(createOrUpdateComment.getText() == null || createOrUpdateComment.getText().isBlank()) throw new IllegalArgumentException();

        Comment comment = adsCommentMapper.createCommentToEntity(createOrUpdateComment);
//        User user = userService.getUserByUsername(authentication.getName());
//        comment.setAuthor(user);
        comment.setAds(adsService.findAdsById(id));
        comment.setCreatedAt(Instant.now());
        commentRepository.save(comment);
        return adsCommentMapper.commentToCommentDto(comment);
    }

    @Override
    public void deleteComment(Integer adId, Integer commentId) {
        Comment comment = getAdsComment(commentId, adId);
        commentRepository.delete(comment);
//        log.info("Comment removed successfully");
    }

    @Override
    public CommentDto updateComments(Integer adId, Integer commentId, CreateOrUpdateComment createOrUpdateComment) {

        if(createOrUpdateComment.getText() == null || createOrUpdateComment.getText().isBlank()) throw new IllegalArgumentException();

        Comment adsComment = getAdsComment(commentId, adId);
        adsComment.setText(createOrUpdateComment.getText());
        commentRepository.save(adsComment);
        return adsCommentMapper.commentToCommentDto(adsComment);
    }

    public Comment getAdsComment(Integer commentId, Integer adId) {
//        log.debug("Getting comment with id: {} for ads with id: {}", commentId, adId);
        return commentRepository.findByIdAndAdsId(commentId, adId).orElseThrow();
    }

    @Override
    public Comment getCommentById(Integer id) {
//        log.debug("Getting comment with id: {}", id);
        return commentRepository.findById(id).orElseThrow();
    }
}
