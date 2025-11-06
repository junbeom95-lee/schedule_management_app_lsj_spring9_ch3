package com.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequest {    //일정 수정 요청 받는 RequestBody

    @Size(max = 30, message = "제목은 최대 30자 이내로 제한합니다")
    @NotBlank(message = "제목을 적어주세요")
    private String title;       //일정 제목
    @NotBlank(message = "작성자를 적어주세요")
    private String author;      //작성자명
    @NotBlank(message = "비밀번호를 적어주세요")
    private String password;    //비밀번호
}
