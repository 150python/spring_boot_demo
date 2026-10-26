package com.example.demo.service.impl;

import com.example.demo.dao.AppointmentDao;
import com.example.demo.service.IAppointmentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @author Administrator
 * @description 具体实现内部业务
 * @create 2026/10/26 20:51
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {
    @Resource
    private AppointmentDao appointmentDao;

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

        int availableNumber = appointmentDao.decreaseRemainNumber(appointmentDate, department);
        if(availableNumber == 0){ return "暂无预约号" ;}




    }

    @Override
    public String cancel(String phone) {
        return null;
    }
}
