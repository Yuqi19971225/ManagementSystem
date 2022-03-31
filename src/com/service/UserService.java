package com.service;

import com.entity.User;
import com.vo.LoginVo;

public interface UserService {
    public int register(User user);

    public boolean login(LoginVo user);
}
