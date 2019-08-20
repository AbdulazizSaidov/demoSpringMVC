package com.vibenar.mapping;

import com.vibenar.entity.User;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapping implements RowMapper<User> {



    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setMiddleName(resultSet.getString("middle_name"));
        user.setNationality(resultSet.getString("nationality"));
        user.setEmail(resultSet.getString("email"));
        user.setPlaceOfStudy(resultSet.getString("study"));
        user.setPhone(resultSet.getString("phone"));
        user.setEducation(resultSet.getString("education"));
        user.setYearOfBirth(resultSet.getDate("date_of_birth"));
        user.setYearOfCompletion(resultSet.getDate("date_of_finish"));

        return user;
    }
}
