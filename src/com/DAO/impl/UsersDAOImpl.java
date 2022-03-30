package com.DAO.impl;

import com.DAO.UsersDAO;
import com.dbutils.DBUtils;
import com.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UsersDAOImpl implements UsersDAO {
    QueryRunner qr = new QueryRunner(DBUtils.dataSource);

    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into users(username,password,age,gender,hobbits,city,birthday) values(?,?,?,?,?,?,?);";
        int result = qr.update(sql, user.getUsername(), user.getPassword(), user.getAge(), user.getGender(), user.getHobby(), user.getCity(), user.getBirthday());
        return result;
    }

    @Override
    public User selectUserByUsernameAndPassword(User user) throws SQLException {
        String sql = "select username,password,age,gender,hobbits,city,birthday from Users where username=? and password=?";
        User result = qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        return result;
    }
}
