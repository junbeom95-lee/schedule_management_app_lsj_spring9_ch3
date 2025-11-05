package com.schedule.repository;

import com.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 데이터베이스 작업 담당
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}