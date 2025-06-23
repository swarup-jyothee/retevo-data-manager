package com.retevo.datamanager.service;

import com.retevo.datamanager.entity.ShelfDetectionReport;
import com.retevo.datamanager.repository.ShelfDetectionReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShelfDetectionReportService {

    @Autowired
    private ShelfDetectionReportRepository reportRepository;

    // ✅ New name for REST API
    public ShelfDetectionReport save(ShelfDetectionReport report) {
        if (report.getTimestamp() == null) {
            report.setTimestamp(LocalDateTime.now());
        }
        return reportRepository.save(report);
    }

    public List<ShelfDetectionReport> getAll() {
        return reportRepository.findAll();
    }

    public ShelfDetectionReport getById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    public boolean exists(Long id) {
        return reportRepository.existsById(id);
    }

    // ✅ Old methods retained for UI usage (or if reused in future)
    public ShelfDetectionReport saveReport(ShelfDetectionReport report) {
        return save(report); // calls the newer method internally
    }

    public List<ShelfDetectionReport> getAllReports() {
        return getAll(); // reuse logic
    }

    public ShelfDetectionReport getReportById(Long id) {
        return getById(id); // reuse logic
    }

    public void deleteReportById(Long id) {
        delete(id); // reuse logic
    }

    public boolean reportExists(Long id) {
        return exists(id); // reuse logic
    }
}
