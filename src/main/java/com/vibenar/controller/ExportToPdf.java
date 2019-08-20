package com.vibenar.controller;

import net.sf.jasperreports.engine.*;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
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

    public static void main(String[] args) {
        String url = "https://integration.ismet.kz/bpmn/api/v1/public/reference/state?id=8";
        HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(250);
                connection.setReadTimeout(250);
                connection.connect();
                StringBuilder sb = new StringBuilder();

                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                while ((line = reader.readLine())!=null){
                    sb.append(line);
                }
                System.out.println(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
