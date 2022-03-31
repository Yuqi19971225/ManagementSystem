package com.DAO;

import com.dbutils.PageUtils;
import com.entity.User;
import com.vo.LoginVo;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    public int insertUser(User user) throws SQLException;
    public User selectUserByUsernameAndPassword(LoginVo user) throws SQLException;

    Integer selectAllCount() throws SQLException;

    List<User> selectUserByPage(PageUtils pageUtils) throws SQLException;
}
