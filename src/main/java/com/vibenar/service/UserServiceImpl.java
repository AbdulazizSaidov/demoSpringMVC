package com.vibenar.service;

import com.vibenar.dao.UserDao;
import com.vibenar.entity.Admin;
import com.vibenar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<Admin> getAdmins(String log, String pass) {
        return userDao.getAdmin(log, pass);
    }

    public List<User> getUser(Integer id) {
        return userDao.getUser(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
       userDao.update(user);
    }

    public void save(User user) {
         userDao.save(user);
    }
}
