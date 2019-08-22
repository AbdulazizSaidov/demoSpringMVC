package com.vibenar.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class SetsService implements SetsServiceDao{
    private static Map<String, String> settingsMap;
    private static JdbcTemplate jdbcTemplate;

    @Autowired
    SetsServiceDao setsServiceDao;

    public SetsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        settingsMap = loadSettings();
    }

    public static Map<String, String> loadSettings() {
        HashMap<String, String> setsMap = new HashMap<>();
        String sql = "select * from project_sets";
        try(Connection connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                setsMap.put(rs.getString("ID"), rs.getString("VALUE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return setsMap;
    }

    public static String getCachedValue(String id) {
        return settingsMap.get(id);
    }



}
