package com.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetOneScheduleCommentResponse {

    private final Long id;                  //댓글 고유 ID
    private final String content;           //댓글 내용
    private final String author;            //작성자명
    private final LocalDateTime createdAt;  //생성일
    private final LocalDateTime modifiedAt; //수정일

    public GetOneScheduleCommentResponse(Long id, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
