package com.example.report.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeReportTest {

    @Test
    void getReportName() {
        EmployeeReport report = new EmployeeReport();
        assertEquals("Employee Report", report.getReportName());
    }

    @Test
    void getSelect() {
        EmployeeReport report = new EmployeeReport();
        assertEquals("id,name,age,department", report.getSelect().trim());
    }

    @Test
    void getColumnName() {
        EmployeeReport report = new EmployeeReport();
        assertEquals("Employee name",report.getColumnName("NAME"));
        assertEquals("UNKNOWN",report.getColumnName("UNKNOWN"));
    }
}