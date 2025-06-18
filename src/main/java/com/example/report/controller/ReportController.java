package com.example.report.controller;

import com.example.report.base.Report;
import com.example.report.domain.EmployeeReport;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ReportController {

    private static final Logger LOGGER = LogManager.getLogger(ReportController.class);

    @Autowired
    private DataSource dataSource;

    public ReportController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/report")
    public String showReport(Model model,
                             @RequestParam(name = "department", required = false) String department) {
        Report report = new EmployeeReport();

        String sql = "SELECT " + report.getSelect() + " FROM " + report.getTableName();
        if (department != null && !department.isEmpty() && sql.toLowerCase().contains("department")) {
            sql += " WHERE department = ?";
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (department != null && !department.isEmpty()) {
                stmt.setString(1, department);
            }

            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = meta.getColumnName(i);
                    Object columnValue = rs.getObject(i);
                    rowMap.put(columnName, columnValue);
                }
                report.getRowList().add(rowMap);
            }

        } catch (SQLException e) {
            LOGGER.error("Problem loading report",e);
        }

        model.addAttribute("report", report);
        return "report";
    }

    @GetMapping("/report/export")
    public void exportCsv(@RequestParam(name = "department", required = false) String department,
                          HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=report.csv");
        Report report = new EmployeeReport();

        String sql = "SELECT " + report.getSelect() + " FROM " + report.getTableName();
        if (department != null && !department.isEmpty() && sql.contains("department")) {
            sql += " WHERE department = ?";
        }
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                PrintWriter writer = response.getWriter()
        ) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Write header
            for (int i = 1; i <= columnCount; i++) {
                writer.print(metaData.getColumnName(i));
                if (i < columnCount) writer.print(",");
            }
            writer.println();

            // Write data rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    writer.print(value != null ? value.toString().replaceAll(",", " ") : "");
                    if (i < columnCount) writer.print(",");
                }
                writer.println();
            }

            writer.flush();
        } catch (SQLException e) {
            throw new IOException("Failed to export CSV", e);
        }
    }

}
