package com.DAO.impl;

import com.DAO.UsersDAO;
import com.dbutils.DBUtils;
import com.dbutils.PageUtils;
import com.entity.User;
import com.vo.LoginVo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    QueryRunner qr = new QueryRunner(DBUtils.dataSource);

    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into users(username,password,age,gender,hobbits,city,birthday) values(?,?,?,?,?,?,?);";
        int result = qr.update(sql, user.getUsername(), user.getPassword(), user.getAge(), user.getGender(), user.getHobby(), user.getCity(), user.getBirthday());
        return result;
    }

    @Override
    public User selectUserByUsernameAndPassword(LoginVo user) throws SQLException {
        String sql = "select username,password,age,gender,hobbits,city,birthday from Users where username=? and password=?";
        User result = qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        return result;
    }

    @Override
    public Integer selectAllCount() throws SQLException {
        String sql = "select count(id) from Users ";
        long result = qr.query(sql, new ScalarHandler<Long>());
        return (int) result;
    }

    @Override
    public List<User> selectUserByPage(PageUtils pageUtils) throws SQLException {
        String sql = "select id,username,password,age,gender,hobbits,city,birthday from Users limit ?,?";
        List<User> users = qr.query(sql, new BeanListHandler<User>(User.class), pageUtils.getStart(), pageUtils.getPageCount());
        return users;
    }
}
