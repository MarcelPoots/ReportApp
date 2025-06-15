package com.example.report.controller;

import com.example.report.model.ReportRow;
import com.example.report.repository.ReportRowRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final ReportRowRepository repository;

    public ReportController(ReportRowRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/report")
    public String showReport(Model model,
                             @RequestParam(name = "department", required = false) String department) {
        List<Object[]> results = repository.findAllNative();
        List<ReportRow> rows = new ArrayList<>();
        for (Object[] row : results) {
            ReportRow reportRow = new ReportRow((String) row[0], ((Number) row[1]).intValue(), (String) row[2]);
            if (department == null || department.isEmpty() ||
                    reportRow.getDepartment().equalsIgnoreCase(department)) {
                rows.add(reportRow);
            }
        }
        model.addAttribute("rows", rows);
        model.addAttribute("selectedDepartment", department);
        return "report";
    }

    @GetMapping("/report/export")
    public void exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=report.csv");

        PrintWriter writer = response.getWriter();
        writer.println("Name,Age,Department");

        List<Object[]> results = repository.findAllNative();
        for (Object[] row : results) {
            writer.printf("%s,%s,%s%n", row[0], row[1], row[2]);
        }

        writer.flush();
        writer.close();
    }
}
