package com.employee.service.serviceImpl;

import com.employee.model.Admin;
import com.employee.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public Boolean verifyLogin(Admin admin) {
        return admin.getUsername().equals("admin") && admin.getPassword().equals("admin");
    }
}
