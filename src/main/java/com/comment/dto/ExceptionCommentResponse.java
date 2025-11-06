package com.comment.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionCommentResponse {

    private final HttpStatus httpStatus;
    private final String message;

    public ExceptionCommentResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
