package com.comment.service;

import com.comment.dto.CreateCommentRequest;
import com.comment.dto.CreateCommentResponse;
import com.comment.entity.Comment;
import com.comment.repository.CommentRepository;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    /**
     * 댓글 생성
     * @param scheduleId 일정 고유 ID
     * @param request CreateCommentRequest (댓글 내용, 작성자명, 비밀번호)
     * @return CreateCommentResponse
     */
    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {

        //1. scheduleId로 일정 가져오기
        //일정이 없으면 등록되지 않은 일정으로 throw
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("등록되지 않은 일정입니다."));

        //2. 일정에 댓글 갯수 확인
        long count = commentRepository.countByScheduleId(scheduleId);

        //3. 10개 미만이면 댓글 생성 가능
        if (count < 10) {
            //3-a. 요청받은 DTO와 가져온 일정으로 Entity로 변환
            Comment comment = new Comment(
                    request.getContent(),
                    request.getAuthor(),
                    request.getPassword(),
                    schedule
            );

            //3-b. 데이터베이스에 엔티티 저장 요청
            Comment savedComment = commentRepository.save(comment);

            //3-c. 저장된 Entity를 response DTO로 변환하여 반환
            CreateCommentResponse response = new CreateCommentResponse(
                    savedComment.getId(),
                    schedule.getId(),
                    savedComment.getContent(),
                    savedComment.getAuthor(),
                    savedComment.getCreatedAt(),
                    savedComment.getModifiedAt());

            return response;
        } else {
            //10개 이상이면 throw
            throw new IllegalStateException("댓글은 10개까지만 작성할 수 있습니다.");
        }
    }
}
