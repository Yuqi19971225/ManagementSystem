package com.service.impl;

import com.DAO.UsersDAO;
import com.DAO.impl.UsersDAOImpl;
import com.dbutils.PageUtils;
import com.entity.User;
import com.service.UserService;
import com.vo.LoginVo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<User> selectUserByPage(PageUtils pageUtils) {
        //初始化分页工具对象
        //每页显示记录条数
        pageUtils.setPageCount(10);
        //当前页起始记录数
        pageUtils.setStart((pageUtils.getCurPage() - 1) * pageUtils.getPageCount());
        //总记录数
        try {
            pageUtils.setTotalCount(usesDAO.selectAllCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //总页数
        if (pageUtils.getTotalCount() % pageUtils.getPageCount() == 0) {
            pageUtils.setTotalPage(pageUtils.getTotalCount() / pageUtils.getPageCount());
        } else {
            pageUtils.setTotalPage(pageUtils.getTotalCount() / pageUtils.getPageCount() + 1);
        }

        try {
            return usesDAO.selectUserByPage(pageUtils);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }
}
