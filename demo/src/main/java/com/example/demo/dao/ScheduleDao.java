package com.example.demo.dao;

import com.example.demo.domain.po.Appointment;
import com.example.demo.domain.po.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description 科室信息
 * @create 2026/10/26 19:58
 */
@Mapper
public interface ScheduleDao {
    void inert(Schedule schedule);

}
