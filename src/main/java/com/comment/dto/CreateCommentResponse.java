package com.comment.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentResponse {    //댓글 생성 응답 ResponseBody

    private final Long id;                  //댓글 고유 ID
    private final Long scheduleId;          //일정 고유 ID
    private final String content;           //댓글 내용
    private final String author;            //작성자명
    private final LocalDateTime createdAt;  //생성일
    private final LocalDateTime modifiedAt; //수정일

    public CreateCommentResponse(Long id, Long scheduleId, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
