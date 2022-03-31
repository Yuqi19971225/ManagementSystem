package com.DAO;

import com.entity.User;
import com.vo.LoginVo;

import java.sql.SQLException;

public interface UsersDAO {
    public int insertUser(User user) throws SQLException;
    public User selectUserByUsernameAndPassword(LoginVo user) throws SQLException;
}
