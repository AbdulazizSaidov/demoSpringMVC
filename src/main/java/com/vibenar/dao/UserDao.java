package com.vibenar.dao;

import com.vibenar.entity.Admin;
import com.vibenar.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<Admin> getAdmin(String log, String pass);
    List<User> getUser(Integer id);
    void delete(int id);
    void update(User user);
    void save(User user);
}
