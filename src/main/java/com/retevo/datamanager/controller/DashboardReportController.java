package com.retevo.datamanager.controller;

import com.retevo.datamanager.entity.ShelfDetectionReport;
import com.retevo.datamanager.service.ShelfDetectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dashboard/reports")
public class DashboardReportController {

    @Autowired
    private ShelfDetectionReportService reportService;

    @GetMapping
    public String showReports(Model model) {
        List<ShelfDetectionReport> reports = reportService.getAllReports();
        model.addAttribute("reports", reports);
        return "dashboard/list"; // templates/dashboard/list.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("report", new ShelfDetectionReport());
        return "dashboard/form"; // templates/dashboard/form.html
    }

    @PostMapping("/add")
    public String addReport(@ModelAttribute ShelfDetectionReport report) {
        reportService.saveReport(report);
        return "redirect:/dashboard/reports";
    }
}
