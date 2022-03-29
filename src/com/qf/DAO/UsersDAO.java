package com.qf.DAO;

import com.qf.entity.User;

import java.sql.SQLException;

public interface UsersDAO {
    public int insertUser(User user) throws SQLException;
    public User selectUserByUsernameAndPassword(User user) throws SQLException;
}
