package com.schedule.service;

import com.schedule.dto.CreateScheduleRequest;
import com.schedule.dto.ScheduleResponse;
import com.schedule.dto.UpdateScheduleRequest;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {  //비즈니스 로직 처리 담당

    //속성
    private final ScheduleRepository scheduleRepository;    //데이터베이스 작업 담당

    //기
    /**
     * 일정 생성 로직
     * @param request CreateScheduleRequest 일정 생성 요청 DTO
     * @return ScheduleResponse 일정 응답 DTO
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
        ScheduleResponse response = new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );

        return response;
    }

    /**
     * 다건 일정 조회 by author
     * @param author 작성자명
     * @return List<ScheduleResponse> 응답 DTO List
     */
    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAllByAuthor(String author) {
        
        //1. 작성자명으로 등록된 일정 목록 전부 조회
        List<Schedule> scheduleList = scheduleRepository.findAllByAuthorOrderByModifiedAtDesc(author);
        
        //2. DTO로 변환
        List<ScheduleResponse> responseList = new ArrayList<>();
        for(Schedule s : scheduleList) {
            responseList.add(new ScheduleResponse(
                    s.getId(),
                    s.getTitle(),
                    s.getContent(),
                    s.getAuthor(),
                    s.getCreatedAt(),
                    s.getModifiedAt()));
        }
        
        //3. 반환
        return responseList;
    }

    /**
     * 다건 일정 조회
     * @return List<ScheduleResponse> 응답 DTO List
     */
    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAll() {

        //1. 등록된 일정 목록 전부 조회
        List<Schedule> scheduleList = scheduleRepository.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));

        //2. DTO로 변환
        List<ScheduleResponse> responseList = new ArrayList<>();
        for(Schedule s : scheduleList) {
            responseList.add(new ScheduleResponse(
                    s.getId(),
                    s.getTitle(),
                    s.getContent(),
                    s.getAuthor(),
                    s.getCreatedAt(),
                    s.getModifiedAt()));
        }

        //3. 반환
        return responseList;
    }

    /**
     * 단건 일정 조회 by id
     * @param id 일정 고유 ID
     * @return ScheduleResponse 일정 응답 DTO
     */
    @Transactional(readOnly = true)
    public ScheduleResponse getOne(Long id) {

        //1. 등록된 일정 id로 조회
        Schedule savedSchedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("등록되지 않은 일정입니다."));

        //2. 저장된 Entity를 response DTO로 변환하여 반환
        ScheduleResponse response = new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );

        //3. DTO 반환
        return response;
    }

    /**
     * 일정 수정
     * 1. id로 선택한 일정 가져오기
     * 2. 비밀번호 확인 후 수정
     * @param id 일정 고유 ID
     * @param request UpdateScheduleRequest 변경할 제목이랑 작성자명과 비교할 비밀번호가 있음
     * @return ScheduleResponse 일정 응답 DTO
     */
    @Transactional
    public ScheduleResponse update(Long id, UpdateScheduleRequest request) {

        //1. 선택한 일정을 먼저 찾음
        Schedule savedSchedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("등록되지 않은 일정입니다."));

        //2. 비밀번호 확인
        if (savedSchedule.getPassword().equals(request.getPassword())) {
            //2-a. 선택한 일정의 제목과 작성자명 수정
            savedSchedule.update(request.getTitle(), request.getAuthor());
        } else {
            //2-b. 일치하지 않으면 throw
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        //3. 수정된 필드를 가지고 DTO에 반환
        ScheduleResponse response = new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );

        //4. response 반환
        return response;
    }
}