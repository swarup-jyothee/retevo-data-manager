package com.retevo.datamanager.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retevo.datamanager.entity.ShelfDetectionReport;
import com.retevo.datamanager.service.ShelfDetectionReportService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
@Tag(name = "Shelf Detection Reports", description = "REST APIs for managing shelf detection reports")
public class ReportRestController {

    @Autowired
    private ShelfDetectionReportService reportService;

    @Operation(summary = "Get all shelf detection reports")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Reports fetched successfully")
    })
    @GetMapping
    public List<ShelfDetectionReport> getAllReports() {
        return reportService.getAll();
    }

    @Operation(summary = "Get a report by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Report found"),
        @ApiResponse(responseCode = "404", description = "Report not found")
    })
    @GetMapping("/{id}")
    public ShelfDetectionReport getReportById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @Operation(
    	    summary = "Create a new report",
    	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
    	        description = "Sample report payload. Only store.id and product.id are required inside nested objects.",
    	        required = true,
    	        content = @Content(
    	            mediaType = "application/json",
    	            examples = @ExampleObject(
    	                name = "Minimal Report Example",
    	                value = """
    	                {
    	                  "inStock": true,
    	                  "compliancePercentage": 85.0,
    	                  "issuesDetected": "Price mismatch",
    	                  "store": { "id": 1 },
    	                  "product": { "id": 2 }
    	                }
    	                """
    	            )
    	        )
    	    )
    	)
    	@ApiResponses({
    	    @ApiResponse(responseCode = "201", description = "Report created successfully")
    	})
    	@PostMapping
    	public ShelfDetectionReport createReport(@RequestBody ShelfDetectionReport report) {
    	    report.setTimestamp(LocalDateTime.now());
    	    return reportService.save(report);
    	}

    @Operation(summary = "Update an existing report by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Report updated successfully"),
        @ApiResponse(responseCode = "404", description = "Report not found")
    })
    @PutMapping("/{id}")
    public ShelfDetectionReport updateReport(@PathVariable Long id, @RequestBody ShelfDetectionReport updatedReport) {
        ShelfDetectionReport existing = reportService.getById(id);
        if (existing != null) {
            updatedReport.setId(id);
            updatedReport.setTimestamp(LocalDateTime.now());
            return reportService.save(updatedReport);
        }
        return null;
    }

    @Operation(summary = "Delete a report by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Report deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Report not found")
    })
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.delete(id);
    }
}
