package com.employee.controller;

import com.employee.model.Attendance;
import com.employee.model.Employee;
import com.employee.service.AttendanceService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class AttendanceController {

    private AttendanceService attendanceService;
    private EmployeeService employeeService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService, EmployeeService employeeService) {
        this.attendanceService = attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping("{id}/attendance")
    public String attendanceForm(Model model, @PathVariable(value = "id") Long id){
        Attendance attendance = new Attendance();
        attendance.setEmployee(employeeService.getEmployeeById(id));
//        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("attendance", attendance);
        return "attendance";
    }

    @PostMapping("{employeeId}/attendance")
    public String addAttendance(@ModelAttribute Attendance attendance,  @PathVariable(value = "employeeId") Long employeeId){
        Attendance employeeAttendance = attendanceService.addEmployeeAttendance(attendance, employeeService.getEmployeeById(employeeId));
        return "redirect:/viewEmployeeDetails/" + employeeAttendance.getEmployee().getId();
    }
}
