package com.vibenar.dao;

import com.vibenar.entity.Admin;
import com.vibenar.entity.User;
import com.vibenar.mapping.AdminMapping;
import com.vibenar.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Date;
public class UserDaoImpl implements UserDao{
    public final JdbcTemplate jdbcTemplate;
    

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<User> findAll() {
         String sql = "SELECT * FROM public.user";
         return jdbcTemplate.query(sql, new UserMapping());
    }

    public List<Admin> getAdmin(String log, String pass) {
        String sql = "SELECT * FROM public.admin where login = ? and password = ? order by id";
        return jdbcTemplate.query(sql, new Object[]{log, pass},  new AdminMapping());
    }

    public List<User> getUser(Integer id) {
        String sql = "SELECT * FROM public.user where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new UserMapping());
    }

    public void delete(int id) {
        String sql = "DELETE FROM public.user where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "UPDATE public.user set name=?, email=?, last_name=?, middle_name=?,nationality=?,date_of_birth=?,study=?,date_of_finish=?,phone=?,education=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getLastName(), user.getMiddleName(),
                user.getNationality(), user.getYearOfBirth(), user.getPlaceOfStudy(), user.getYearOfCompletion(),
                user.getPhone(), user.getEducation(), user.getId());
    }

    public void save(User user) {
        String sql = "INSERT INTO public.user (name, email, last_name, middle_name, nationality, " +
                "date_of_birth, study, date_of_finish, phone, education) VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getLastName(), user.getMiddleName(),
                user.getNationality(), user.getYearOfBirth(), user.getPlaceOfStudy(), user.getYearOfCompletion(),
                user.getPhone(), user.getEducation());
    }

 }
