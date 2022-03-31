package com.service.impl;

import com.DAO.AdminDAO;
import com.DAO.impl.AdminDAOImpl;
import com.entity.Admin;
import com.service.AdminService;
import com.vo.LoginVo;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean login(LoginVo user) {
        Admin result = null;
        try {
            result = adminDAO.selectByUsernameAndPassword(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != null) {
            return true;
        }
        return false;
    }
}
