package com.employee.controller;

import com.employee.model.Admin;
import com.employee.model.Employee;
import com.employee.service.AdminService;
import com.employee.service.AttendanceService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private AdminService adminService;
    private AttendanceService attendanceService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AdminService adminService, AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.adminService = adminService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/employee")
    public String viewHomePage(Model model, HttpSession session){

        Admin admin = (Admin) session.getAttribute("admin");

        if(admin != null && adminService.verifyLogin(admin)) {
            model.addAttribute("listEmployees", employeeService.getAllEmployees());
            return "index";
        }

        return "redirect:/";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";

    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee";

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/viewEmployeeDetails/{id}")
    public String viewEmployeeDetails(@PathVariable Long id,  Model model) {

//        System.out.println("id ============================" + id);
        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("employeeAttendance", attendanceService.getAttendanceByEmployee(employee));
        return "view-employee-details";
    }


}
