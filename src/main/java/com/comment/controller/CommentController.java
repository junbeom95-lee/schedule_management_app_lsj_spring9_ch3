package com.comment.controller;

import com.comment.dto.CreateCommentRequest;
import com.comment.dto.CreateCommentResponse;
import com.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 생성
     * @param scheduleId 일정 고유 ID
     * @param request CreateCommentRequest 댓글 내용
     * @return ResponseEntity 상태코드 및 Body (CreateCommentResponse 응답 DTO)
     */
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request) {

        CreateCommentResponse result = commentService.save(scheduleId, request);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
