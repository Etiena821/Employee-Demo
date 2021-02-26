package com.employee.service.serviceImpl;

import com.employee.model.Attendance;
import com.employee.model.Employee;
import com.employee.repository.AttendanceRepository;
import com.employee.service.AttendanceService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;
    private EmployeeService employeeService;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeService employeeService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
    }

    @Override
    public Attendance addEmployeeAttendance(Attendance attendance, Employee employee) {
        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findAttendanceByEmployee(employee);
    }

}
