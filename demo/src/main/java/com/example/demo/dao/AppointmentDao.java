package com.example.demo.dao;

import com.example.demo.domain.po.Appointment;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description 预约
 * @create 2026/10/26 19:58
 */
@Mapper
public interface AppointmentDao {
    void insert(Appointment appointment);
    boolean existsByPhone(String phone);
    int decreaseRemainNumber(LocalDate appointmentDate, String department);
    int increaseRemainNumber(LocalDate appointmentDate, String department);
}
