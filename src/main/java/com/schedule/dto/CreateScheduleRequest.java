package com.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {    //일정 생성 요청 받는 RequestBody

    private String title;       //일정제목
    private String content;     //일정내용
    private String author;      //작성자명
    private String password;    //비밀번호
}
