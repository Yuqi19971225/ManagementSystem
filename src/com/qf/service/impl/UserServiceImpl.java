package com.qf.service.impl;

import com.qf.DAO.UsersDAO;
import com.qf.DAO.impl.UsersDAOImpl;
import com.qf.dbutils.DBUtils;
import com.qf.entity.User;
import com.qf.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    //创建用户访问对象
    UsersDAO usesDAO = new UsersDAOImpl();

    @Override
    public int register(User user) {
        try {
            return usesDAO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User login(User user) {
        try {
            return usesDAO.selectUserByUsernameAndPassword(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
