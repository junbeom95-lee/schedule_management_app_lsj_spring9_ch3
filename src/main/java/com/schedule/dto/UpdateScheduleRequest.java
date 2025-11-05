package com.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {    //일정 수정 요청 받는 RequestBody

    private String title;       //일정 제목
    private String author;      //작성자명
    private String password;    //비밀번호
}
