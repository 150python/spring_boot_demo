package com.example.demo.webservice;

import com.example.demo.domain.po.Appointment;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description SOAP 服务接口
 * @create 2026/10/26 20:41
 */
public interface IAppointmentWebService {
    String appoint(LocalDate date, String department, String phone);
    String cancel(String phone);
}
