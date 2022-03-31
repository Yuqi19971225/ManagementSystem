package com.service.impl;

import com.DAO.UsersDAO;
import com.DAO.impl.UsersDAOImpl;
import com.entity.User;
import com.service.UserService;
import com.vo.LoginVo;

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
    public boolean login(LoginVo user) {

        User user1 = null;
        try {
            user1 = usesDAO.selectUserByUsernameAndPassword(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user1 == null) {
            return false;
        } else {
            return true;
        }
    }
}
