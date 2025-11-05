package com.schedule.service;

import com.schedule.dto.CreateScheduleRequest;
import com.schedule.dto.CreateScheduleResponse;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {  //비즈니스 로직 처리 담당

    //속성
    private final ScheduleRepository scheduleRepository;    //데이터베이스 작업 담당

    //생

    //기
    /**
     * 일정 생성 로직
     * @param request CreateScheduleRequest 일정 생성 요청 DTO
     * @return CreateScheduleResponse 일정 생성 응답 DTO
     */
    @Transactional
    public ScheduleResponse save(CreateScheduleRequest request) {

        //1. 요청받은 DTO를 Entity로 변환
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword());

        //2. 데이터베이스에 엔티티 저장 요청
        Schedule savedSchedule = scheduleRepository.save(schedule);

        //3. 저장된 Entity를 response DTO로 변환하여 반환
        CreateScheduleResponse response = new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );

        return response;
    }
}