package com.example.report.base;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Report {

    String getTableName();
    String getReportName();
    String getColumnName(String fieldName);
    Set<String> getColumNames();
    List<Map<String, Object>> getRowList();
    /**
     * @return String with set of fields that can be used in select query
     */
    String getSelect();
}
