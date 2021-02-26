package com.employee.service;

import com.employee.model.Attendance;
import com.employee.model.Employee;

import java.util.List;

public interface AttendanceService {
    Attendance addEmployeeAttendance(Attendance attendance, Employee employee);
    List<Attendance> getAttendanceByEmployee(Employee employee);
}
