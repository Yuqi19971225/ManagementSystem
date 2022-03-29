package com.qf.service;

import com.qf.entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {
    public int register(User user);

    public User login(User user);
}
