package com.example.report.domain;

import com.example.report.base.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeReport implements Report {

    private final String[] fields = {"id", "name", "age", "department"};

    private static final String REPORT_NAME = "Employee Report";

    List<Map<String, Object>> rowList = new ArrayList<>();

    @Override
    public String getReportName() {
        return REPORT_NAME;
    }

    @Override
    public List<Map<String, Object>> getRowList() {
        return rowList;
    }

    @Override
    public String getSelect() {
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field).append(",");
        }
        result.delete(result.length() - 1, result.length()); // remove last ','
        return result.toString();
    }

}
