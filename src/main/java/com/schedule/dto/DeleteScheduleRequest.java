package com.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequest {    //일정 삭제 요청 받는 RequestBody
    @NotBlank(message = "비밀번호를 적어주세요")
    private String password;
}
