package com.qf.DAO.impl;

import com.qf.DAO.AdminDAO;
import com.qf.dbutils.DBUtils;
import com.qf.entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDAO {
    QueryRunner qr = new QueryRunner();

    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(String username) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        String sql = "select * from Admins where username=?";
        try {
            Admin admin = qr.query(DBUtils.getConnection(), sql, new BeanHandler<Admin>(Admin.class), username);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        String sql = "select * from Admins where position = '学生'";
        try {
            List<Admin> list = qr.query(DBUtils.getConnection(), sql, new BeanListHandler<Admin>(Admin.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
