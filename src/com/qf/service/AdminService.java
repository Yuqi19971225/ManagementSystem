package com.qf.service;

import com.qf.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String username, String password);

    public List<Admin> showAllStudents();
}
