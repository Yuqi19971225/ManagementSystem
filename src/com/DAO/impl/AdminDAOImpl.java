package com.DAO.impl;

import com.DAO.AdminDAO;
import com.dbutils.DBUtils;
import com.entity.Admin;
import com.vo.LoginVo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    QueryRunner qr = new QueryRunner(DBUtils.dataSource);

    @Override
    public Admin selectByUsernameAndPassword(LoginVo user) throws SQLException {
        String sql = "select username,password from admins where username=? and password=?";
        Admin result = qr.query(sql, new BeanHandler<>(Admin.class), user.getUsername(), user.getPassword());
        return result;
    }
}
