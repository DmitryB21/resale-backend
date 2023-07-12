package com.skypro.resale.service.impl;

import com.skypro.resale.dto.CommentDto;
import com.skypro.resale.dto.CreateOrUpdateComment;
import com.skypro.resale.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
//    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    private final AdsServiceImpl adsService;

    @Override
    public List<CommentDto> getComments(Integer id) {
//        return commentRepository.findAllByAdsId(id)
//                .stream()
//                .map(AdsCommentMapper.INSTANSE::toDto)
//                .collect(Collectors.toList());
        return new ArrayList<>();
    }

    @Override
    public CommentDto addComment(Integer id, CreateOrUpdateComment createOrUpdateComment) {

//        if(adsCommentDto.getText() == null || adsCommentDto.getText().isBlank()) throw new IncorrectArgumentException();
//
//        Comment comment = AdsCommentMapper.INSTANSE.toEntity(adsCommentDto);
//        User user = userService.getUserByUsername(authentication.getName());
//        comment.setAuthor(user);
//        comment.setAds(adsService.findAdsById(id));
//        comment.setCreatedAt(Instant.now());
//        commentRepository.save(comment);
//        return AdsCommentMapper.INSTANSE.toDto(comment);
        return new CommentDto();
    }

    @Override
    public void deleteComment(Integer adId, Integer commentId) {
//        Comment comment = getAdsComment(commentId, adId);
//        commentRepository.delete(comment);
//        log.info("Comment removed successfully");
    }

    @Override
    public CommentDto updateComments(Integer adId, Integer commentId, CreateOrUpdateComment createOrUpdateComment) {

//        if(adsCommentDto.getText() == null || adsCommentDto.getText().isBlank()) throw new IncorrectArgumentException();
//
//        Comment adsComment = getAdsComment(commentId, adId);
//        adsComment.setText(adsCommentDto.getText());
//        commentRepository.save(adsComment);
//        return AdsCommentMapper.INSTANSE.toDto(adsComment);
        return new CommentDto();
    }

//    public Comment getAdsComment(Integer commentId, Integer adId) {
//        log.debug("Getting comment with id: {} for ads with id: {}", commentId, adId);
//        return commentRepository.findByIdAndAdsId(commentId, adId).orElseThrow(CommentNotFoundException::new);
//    }
//
//    @Override
//    public Comment getCommentById(Integer id) {
//        log.debug("Getting comment with id: {}", id);
//        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
//    }
}
