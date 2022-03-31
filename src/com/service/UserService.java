package com.service;

import com.dbutils.PageUtils;
import com.entity.User;
import com.vo.LoginVo;

import java.util.List;

public interface UserService {
    public int register(User user);

    public boolean login(LoginVo user);

    List<User> selectUserByPage(PageUtils pageUtils);
}
