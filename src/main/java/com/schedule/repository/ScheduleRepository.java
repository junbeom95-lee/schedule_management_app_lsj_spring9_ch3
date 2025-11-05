package com.schedule.repository;

import com.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 데이터베이스 작업 담당
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //select * from scheduel where = 작성자명 order by modifiedAt desc;
    List<Schedule> findAllByAuthorOrderByModifiedAtDesc(String author);
}