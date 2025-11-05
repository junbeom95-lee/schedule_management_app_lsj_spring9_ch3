package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {   //일정 응답 ResponseBody

    private final Long id;                    //일정 고유 ID
    private final String title;               //일정 제목
    private final String content;             //일정 내용
    private final String author;              //작성자명
    private final LocalDateTime createdAt;    //생성일
    private final LocalDateTime modifiedAt;   //수정일

    public ScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
