package com.employee.service;

import com.employee.model.Admin;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


public interface AdminService {
    Boolean verifyLogin(Admin admin);
}
