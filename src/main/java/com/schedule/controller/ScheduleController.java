package com.schedule.controller;

import com.schedule.dto.CreateScheduleRequest;
import com.schedule.dto.ScheduleResponse;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {   //사용자가 애플리케이션과 상호작용하는 사용자 인터페이스 및 커뮤니케이션 계층

    //속성
    private final ScheduleService scheduleService;    //비즈니스 로직 처리 담당

    //기능
    /**
     * 일정 생성
     * @param request CreateScheduleRequest 일정 생성 요청 DTO
     * @return ResponseEntity 상태코드 및 Body ScheduleResponse(일정 응답 DTO) 설정
     */
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {

        //1. 요청데이터를 서비스로 전달하여 연산 수행 (비즈니스 로직 수행)하고 응답데이터 생성
        ScheduleResponse result = scheduleService.save(request);

        //2. 반환 - 상태코드 201 - body
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * 작성자명 기준으로 전체(다건) 일정 조회
     * @param author 작성자명 nullable
     * @return ResponseEntity 상태코드 및 Body List<ScheduleResponse> (일정 응답 List DTO) 설정
     */
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> getAllByAuthor(@RequestParam(required = false) String author) {

        List<ScheduleResponse> result;

        //1. 요청 데이터를 서비스로 전달하여 로직 수행
        if(author == null || author.isEmpty()) {    //1-a. 작성자명이 null 인 경우
            result = scheduleService.getAll();
        } else {                                    //1-b. 작성자명이 있을 경우
            result = scheduleService.getAllByAuthor(author);
        }

        //2. 반환 - 상태코드 200 - body
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * id 기준으로 하나(단건) 일정 조회
     * @param id 일정 고유 ID
     * @return ResponseEntity 상태코드 및 Body ScheduleResponse(일정 응답 DTO) 설정
     */
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponse> getOne(@PathVariable Long id) {

        //1. 요청 데이터를 서비스로 전달하여 로직 수행
        ScheduleResponse result = scheduleService.getOne(id);

        //2. 반환 - 상태코드 200 - body
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //TODO 일정 수정  - 일정 고유 id 로 선택한 일정을 수정 Method - PUT
    //TODO Request : 일정 제목, 작성자명, 비밀번호
}