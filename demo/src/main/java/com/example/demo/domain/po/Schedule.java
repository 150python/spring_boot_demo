package com.example.demo.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * @author Administrator
 * @description 科室信息
 * @create 2026/10/26 19:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {
    private Long id;
    private LocalDate appointmentDate;
    private String department;
    private Integer remainNumber;
}
