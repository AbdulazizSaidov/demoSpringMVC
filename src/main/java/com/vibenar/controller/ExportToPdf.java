package com.vibenar.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.HashMap;

public class ExportToPdf implements ExportToPdfIn{


public final JdbcTemplate jdbcTemplate;

    public ExportToPdf(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    }

    public JasperPrint toPdf(Long id, HttpServletResponse response) {
        JasperPrint jasperPrint = null;
        try {
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));
        OutputStream out = response.getOutputStream();
        Connection con = jdbcTemplate.getDataSource().getConnection();
        String jasperFileName = getClass().getResource("/reports/CV.jrxml").getFile();
        FileInputStream  inputStream = new FileInputStream(jasperFileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("ID", id);
        jasperPrint = JasperFillManager.fillReport(jasperReport, param, con);
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jasperPrint;

    }


}
