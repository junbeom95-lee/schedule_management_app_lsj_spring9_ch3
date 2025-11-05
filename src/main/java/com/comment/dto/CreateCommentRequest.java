package com.comment.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequest { //댓글 생성 요청 받는 RequestBody

    private String content;     //댓글 내용
    private String author;      //작성자명
    private String password;    //비밀번호
}
