package com.example.report.domain;

import com.example.report.base.Report;
import com.example.report.controller.ReportController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.example.report.domain.EmployeeReportConstants.*;

public class EmployeeReport implements Report {

    private static final Logger LOGGER = LogManager.getLogger(ReportController.class);

    private static final String[] TABEL_FIELDS = {TABLE_FIELD_ID, TABLE_FIELD_NAME, TABLE_FIELD_AGE, TABLE_FIELD_DEPARTMENT, TABLE_FIELD_LANGUAGE};

    private static final Map<String, String> columNames;
    static {
        Map<String, String> aMap = new HashMap<>();
        aMap.put(TABLE_FIELD_ID, "ID");
        aMap.put(TABLE_FIELD_NAME, "Employee name");
        aMap.put(TABLE_FIELD_AGE, "Age");
        aMap.put(TABLE_FIELD_DEPARTMENT, "Department");
        columNames = Collections.unmodifiableMap(aMap);
    }

    private static final String REPORT_NAME = "Employee Report";

    List<Map<String, Object>> rowList = new ArrayList<>();

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

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
        for (String field : TABEL_FIELDS) {
            result.append(field).append(",");
        }
        result.delete(result.length() - 1, result.length()); // remove last ','
        return result.toString();
    }

    @Override
    public String getColumnName(String fieldName){
        return columNames.getOrDefault(fieldName, fieldName);
    }

    public Set<String> getColumNames() {
        Set<String> result = new LinkedHashSet<>();
        getRowList().get(0).keySet()
                .forEach(key -> {
                    LOGGER.info("Key " + key);
                    LOGGER.info("getColumnName(key) " +getColumnName(key));
                    result.add(getColumnName(key));
                });
        return result;
    }

}
