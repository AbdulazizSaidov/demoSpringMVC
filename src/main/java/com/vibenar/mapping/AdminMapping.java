package com.vibenar.mapping;

import com.vibenar.entity.Admin;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminMapping implements RowMapper<Admin> {


    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setId(resultSet.getInt("id"));
        admin.setLogin(resultSet.getString("login"));
        admin.setPass(resultSet.getString("password"));
        return admin;
    }


}
