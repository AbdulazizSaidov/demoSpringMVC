package com.vibenar.dao;

import com.vibenar.entity.Admin;
import com.vibenar.entity.User;
import com.vibenar.mapping.AdminMapping;
import com.vibenar.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    public final JdbcTemplate jdbcTemplate;
    

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<User> findAll() {
         String sql = "SELECT * FROM public.employees";
         return jdbcTemplate.query(sql, new UserMapping());
    }

    public List<Admin> getAdmin(String log, String pass) {
        String md5Digest = getMd5Digest(pass);
        String sql = "SELECT * FROM public.users where login = ? and password = ? order by id";
        return jdbcTemplate.query(sql, new Object[]{log, md5Digest},  new AdminMapping());
    }

    private String getMd5Digest(String input)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String s = number.toString(16);
            while (s.length() < 32)
                s = "0" + s;
            return s;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
    public List<User> getUser(Integer id) {
        String sql = "SELECT * FROM public.employees where id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},  new UserMapping());
    }

    public void delete(int id) {
        String sql = "DELETE FROM public.employees where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "UPDATE public.employees set name=?, email=?, last_name=?, middle_name=?,nationality=?,date_of_birth=?,study=?,date_of_finish=?,phone=?,education=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getLastName(), user.getMiddleName(),
                user.getNationality(), user.getBirth(), user.getPlaceOfStudy(), user.getCompleaton(),
                user.getPhone(), user.getEducation(), user.getId());
    }

    public void save(User user) {
        String sql = "INSERT INTO public.employees (name, email, last_name, middle_name, nationality, " +
                "date_of_birth, study, date_of_finish, phone, education) VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getLastName(), user.getMiddleName(),
                user.getNationality(), user.getBirth(), user.getPlaceOfStudy(), user.getCompleaton(),
                user.getPhone(), user.getEducation());
    }

 }
