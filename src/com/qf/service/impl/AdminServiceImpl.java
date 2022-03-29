package com.qf.service.impl;

import com.qf.DAO.AdminDAO;
import com.qf.DAO.impl.AdminDaoImpl;
import com.qf.dbutils.DBUtils;
import com.qf.entity.Admin;
import com.qf.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        Admin result = null;
        try {
            DBUtils.begin();
            Admin admin = adminDAO.select(username);
            if (admin != null) {
                if (admin.getPassword().equals(password)) {
                    result = admin;
                }
            }
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollBack();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> showAllStudents() {
        return null;
    }
}
