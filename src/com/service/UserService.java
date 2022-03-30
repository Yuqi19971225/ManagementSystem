package com.service;

import com.entity.User;

public interface UserService {
    public int register(User user);

    public User login(User user);
}
