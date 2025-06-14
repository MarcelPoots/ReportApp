package com.example.report.controller;

import com.example.report.model.ReportRow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String showReport(Model model) {
        List<ReportRow> rows = List.of(
                new ReportRow("Alice", 30, "Engineering"),
                new ReportRow("Bob", 25, "Marketing"),
                new ReportRow("Charlie", 35, "Finance")
        );
        model.addAttribute("rows", rows);
        return "report";
    }
}
