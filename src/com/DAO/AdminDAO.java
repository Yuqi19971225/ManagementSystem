package com.DAO;

import com.entity.Admin;
import com.vo.LoginVo;

import java.sql.SQLException;

public interface AdminDAO {
    public Admin selectByUsernameAndPassword(LoginVo user) throws SQLException;
}
