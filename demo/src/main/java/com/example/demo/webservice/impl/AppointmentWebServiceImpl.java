package com.example.demo.webservice.impl;

import com.example.demo.domain.po.Appointment;
import com.example.demo.service.IAppointmentService;
import com.example.demo.webservice.IAppointmentWebService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description SOAP 服务实现
 * @create 2026/10/26 20:42
 */
@Service
public class AppointmentWebServiceImpl implements IAppointmentWebService {
    private IAppointmentService appointmentService;
    @Override
    public String appoint(LocalDate appointmentDate, String department, String phone) {
        return appointmentService.appoint(appointmentDate, department, phone);
    }

    @Override
    public String cancel(String phone) {
        return appointmentService.cancel(phone);
    }
}
