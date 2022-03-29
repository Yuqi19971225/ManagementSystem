package com.qf.DAO;

import com.qf.entity.Admin;

import java.util.List;

public interface AdminDAO {
    public int insert(Admin admin);
    public int delete(String username);
    public int update(Admin admin);
    public Admin select(String username);
    public List<Admin> selectAll();
}
