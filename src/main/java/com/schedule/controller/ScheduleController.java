package com.schedule.controller;

import com.schedule.dto.CreateScheduleRequest;
import com.schedule.dto.CreateScheduleResponse;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {   //사용자가 애플리케이션과 상호작용하는 사용자 인터페이스 및 커뮤니케이션 계층

    private final ScheduleService scheduleService;    //비즈니스 로직 처리 담당

    /**
     * 일정 생성
     * @param request CreateScheduleRequest 일정 생성 요청 DTO
     * @return ResponseEntity 상태코드 및 Body CreateScheduleResponse(일정 생성 응답 DTO) 설정
     */
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {

        //1. 요청데이터를 서비스로 전달하여 연산 수행 (비즈니스 로직 수행)하고 응답데이터 생성
        CreateScheduleResponse result = scheduleService.save(request);

        //2. 반환 - 상태코드 201 - body
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //TODO 일정 조회 (전체 일정 조회) - 작성자명 기준 (nullable)

    //TODO 일정 조회 (단건 일정 조회) - id 기준
}