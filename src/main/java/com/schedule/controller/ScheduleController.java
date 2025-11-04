package com.schedule.controller;

import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    //TODO 일정 생성
}