package com.example.demo.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


/**
 * @author Administrator
 * @description 预约记录实体类
 * @create 2026/10/26 19:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    private Long id;
    private LocalDate appointmentDate;
    private String department;
    private String phone;
}
