package com.example.demo.service.impl;

import com.example.demo.dao.AppointmentDao;
import com.example.demo.dao.ScheduleDao;
import com.example.demo.domain.po.Appointment;
import com.example.demo.service.IAppointmentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @description 具体实现内部业务
 * @create 2026/10/26 20:51
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^1[3-9]\\d{9}$");

    @Resource
    private AppointmentDao appointmentDao;
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String appoint(LocalDate appointmentDate, String department, String phone) {
        if(!isAvailableDate(appointmentDate)){
            return "不在预约日期内";
        }

        if(!isValidPhone(phone)){
            return "无效号码，请重新输入手机号码";
        }
        if(appointmentDao.existsByPhone(phone)){
            return "此号已经预约过了";
        }

        int availableNumber = scheduleDao.decreaseRemainNumber(appointmentDate, department);
        if(availableNumber == 0){ return "暂无预约号" ;}

        Appointment appointment = Appointment.builder().appointmentDate(appointmentDate)
                .department(department)
                .phone(phone)
                .build();
        appointmentDao.insert(appointment);
        return "预约成功";


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String cancel(String phone) {
        if(!isValidPhone(phone)){
            return "无效号码,请重新输入手机号码";
        }
        Appointment appointment = appointmentDao.findByPhone(phone);

        if(appointment == null){
            return "改手机号尚未预约";
        }

        appointmentDao.deleteByPhone(phone);

        scheduleDao.increaseRemainNumber(appointment.getAppointmentDate(), appointment.getDepartment());
        return "取消预约成功";
    }

    private boolean isAvailableDate(LocalDate appointmentDate){
        if(appointmentDate == null){
            return false;
        }
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate houtian = LocalDate.now().plusDays(2);
        return appointmentDate.equals(tomorrow) || appointmentDate.equals(houtian);
    }

    private boolean isValidPhone(String phone){
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
}
