package com.example.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.RepositoryDefinition;

@Repository
@RepositoryDefinition(domainClass = com.example.report.model.ReportRow.class, idClass = java.lang.Long.class)
public interface ReportRowRepository {

    @Query(value = "SELECT name, age, department FROM report_row", nativeQuery = true)
    List<Object[]> findAllNative();
}
