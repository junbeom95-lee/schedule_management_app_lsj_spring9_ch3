package com.schedule.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionScheduleResponse {

    private final HttpStatus httpStatus;  //상태 코드
    private final String message;         //에러 메시지

    public ExceptionScheduleResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
