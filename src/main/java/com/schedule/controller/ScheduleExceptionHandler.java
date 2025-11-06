package com.schedule.controller;

import com.schedule.dto.ExceptionScheduleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.schedule.controller")
public class ScheduleExceptionHandler { //ScheduleController에 대한 ExceptionHandler

    /**
     * 유저의 입력에 대한 검증 수행해서 잘못된 값이 들어왔을 때 반환하는 Exception
     * @param e MethodArgumentNotValidException
     * @return ResponseEntity 상태코드 및 Body ExceptionResponse (상태코드, 메시지)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionScheduleResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        //1. 응답 DTO 생성 및 반환
        ExceptionScheduleResponse exceptionResponse = new ExceptionScheduleResponse(HttpStatus.BAD_REQUEST, e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    /**
     * DB에 없는 데이터를 요청할 때 반환하는 Exception
     * @param e IllegalStateException
     * @return ResponseEntity 상태코드 및 Body ExceptionResponse (상태코드, 메시지)
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionScheduleResponse> illegalStateException(IllegalStateException e) {

        ExceptionScheduleResponse exceptionResponse = new ExceptionScheduleResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    /**
     * DB에 있는 비밀번호와 일치하지가 않을 때 Exception
     * @param e illegalArgumentException
     * @return ResponseEntity 상태코드 및 Body ExceptionResponse (상태코드, 메시지)
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionScheduleResponse> illegalArgumentException(IllegalArgumentException e) {
        ExceptionScheduleResponse exceptionResponse = new ExceptionScheduleResponse(HttpStatus.FORBIDDEN, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
