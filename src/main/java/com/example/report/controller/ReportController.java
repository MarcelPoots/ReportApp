package com.example.report.controller;

import com.example.report.model.ReportRow;
import com.example.report.repository.ReportRowRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final ReportRowRepository repository;

    public ReportController(ReportRowRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/report")
    public String showReport(Model model) {
        List<Object[]> results = repository.findAllNative();
        List<ReportRow> rows = new ArrayList<>();
        for (Object[] row : results) {
            rows.add(new ReportRow((String) row[0], ((Number) row[1]).intValue(), (String) row[2]));
        }
        model.addAttribute("rows", rows);
        return "report";
    }
}
