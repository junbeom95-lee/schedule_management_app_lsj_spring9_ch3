package com.schedule.dto;

import com.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetOneScheduleResponse {   //단건 조회 일정 Response

    private final Long id;                      //일정 고유 ID
    private final String title;                 //일정 제목
    private final String content;               //일정 내용
    private final String author;                //작성자명
    private final LocalDateTime createdAt;      //생성일
    private final LocalDateTime modifiedAt;     //수정일
    private final List<Comment> commentList;    //일정에 등록된 댓글들

    public GetOneScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentList = commentList;
    }
}
