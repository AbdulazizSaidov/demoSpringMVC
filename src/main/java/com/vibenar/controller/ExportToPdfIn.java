package com.vibenar.controller;

import net.sf.jasperreports.engine.JasperPrint;

import javax.servlet.http.HttpServletResponse;

public interface ExportToPdfIn {

    JasperPrint toPdf(Long id, HttpServletResponse response);
}
