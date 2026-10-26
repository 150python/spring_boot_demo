package com.example.demo.service;

import com.example.demo.domain.po.Appointment;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description 具体实现内务业务接口
 * @create 2026/10/26 20:51
 */
public interface IAppointmentService {
    String appoint(LocalDate appointmentDate, String department, String phone);
    String cancel(String phone);
}
