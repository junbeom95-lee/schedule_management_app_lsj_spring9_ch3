package com.comment.controller;

import com.comment.dto.ExceptionCommentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.comment.controller")
public class CommentExceptionHandler {  //CommentController ExceptionHandler

    /**
     * 유저의 입력에 대한 검증 수행해서 잘못된 값이 들어왔을 때 반환하는 Exception
     * @param e MethodArgumentNotValidException
     * @return ResponseEntity 상태코드 및 Body ExceptionResponse (상태코드, 메시지)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionCommentResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        ExceptionCommentResponse exceptionResponse = new ExceptionCommentResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    /**
     * DB에 없는 데이터를 요청하거나 비밀번호가 틀릴 때 반환하는 Exception
     * @param e IllegalStateException
     * @return ResponseEntity 상태코드 및 Body ExceptionResponse (상태코드, 메시지)
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionCommentResponse> illegalStateException(IllegalStateException e) {

        ExceptionCommentResponse exceptionResponse = new ExceptionCommentResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
