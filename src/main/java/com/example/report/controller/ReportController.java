package com.example.report.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {


    @Autowired
    private DataSource dataSource;

    public ReportController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/report")
    public String showReport(Model model,
                             @RequestParam(name = "department", required = false) String department) {
        List<Map<String, Object>> rowList = new ArrayList<>();
        String sql = "SELECT id, name, age, department FROM report_row";
        if (department != null && !department.isEmpty()) {
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
                    System.err.println( meta.getColumnClassName(i));
                    Object columnValue = rs.getObject(i);
                    rowMap.put(columnName, columnValue);
                }
                rowList.add(rowMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("rows", rowList);
        return "report";

    }

    @GetMapping("/report/export")
    public void exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=report.csv");

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT id, name, age, department FROM report_row");
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
