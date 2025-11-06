package com.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCommentRequest { //댓글 생성 요청 받는 RequestBody

    @Size(max = 100, message = "내용은 최대 100자 이내로 제한됩니다")
    @NotBlank(message = "내용을 적어주세요")
    private String content;     //댓글 내용
    @NotBlank(message = "작성자를 적어주세요")
    private String author;      //작성자명
    @NotBlank(message = "비밀번호를 적어주세요")
    private String password;    //비밀번호
}
