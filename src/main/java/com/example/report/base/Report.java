package com.example.report.base;

import java.util.List;
import java.util.Map;

public interface Report {

    String getReportName();

    List<Map<String, Object>> getRows();

    /**
     * @return String with set of fields that can be used in select query
     */
    String getSelect();
}
