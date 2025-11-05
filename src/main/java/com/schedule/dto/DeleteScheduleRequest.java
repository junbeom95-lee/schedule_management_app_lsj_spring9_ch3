package com.schedule.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequest {    //일정 삭제 요청 받는 RequestBody
    private String password;
}
