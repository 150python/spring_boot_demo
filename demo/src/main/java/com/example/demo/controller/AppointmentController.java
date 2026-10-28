package com.example.demo.controller;

import com.example.demo.domain.po.Appointment;
import com.example.demo.service.IAppointmentService;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @Resource
    private IAppointmentService appointmentService;

    @GetMapping
    public String appointmentPage(Model model) {
        model.addAttribute("tomorrow", LocalDate.now().plusDays(1));
        model.addAttribute("houtian", LocalDate.now().plusDays(2));
        model.addAttribute("departments", List.of("内科", "外科"));
        return "appointment";

    }

    @PostMapping("/create")
    public String createAppointment(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate appointmentDate,

            @RequestParam
            String department,

            @RequestParam
            String phone,

            RedirectAttributes redirectAttributes
    ) {
        String result = appointmentService.appoint(appointmentDate, department, phone);
        redirectAttributes.addFlashAttribute("message", result);
        redirectAttributes.addFlashAttribute(
                "selectedAppointmentDate", appointmentDate
        );
        redirectAttributes.addFlashAttribute(
                "selectedDepartment", department
        );
        redirectAttributes.addFlashAttribute(
                "appointmentPhone", phone
        );
        return "redirect:/appointment";
    }

    @PostMapping("/cancel")
    public String cancelAppointment(
            @RequestParam
            String phone,
            RedirectAttributes redirectAttributes
    ){
        String result = appointmentService.cancel(phone);
        redirectAttributes.addFlashAttribute("message", result);
        return "redirect:/appointment";
    }
}