package com.retevo.datamanager.repository;

import com.retevo.datamanager.entity.ShelfDetectionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfDetectionReportRepository extends JpaRepository<ShelfDetectionReport, Long> {
}
