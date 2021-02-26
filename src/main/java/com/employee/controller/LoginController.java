package com.employee.controller;

import com.employee.model.Admin;
import com.employee.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Login form
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute Admin admin, HttpSession session) {
        if(adminService.verifyLogin(admin)){
            session.setAttribute("admin", admin);

            return "redirect:/employee";
        }
        return "redirect:/";
    }

}
