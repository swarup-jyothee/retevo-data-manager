package com.retevo.datamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retevo.datamanager.repository.ProductRepository;
import com.retevo.datamanager.repository.RegionRepository;
import com.retevo.datamanager.repository.StoreRepository;
import com.retevo.datamanager.service.ShelfDetectionReportService;

@Controller
@RequestMapping("/views")
public class EntityViewController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private StoreRepository storeRepo;

    @Autowired
    private RegionRepository regionRepo;

    @Autowired
    private ShelfDetectionReportService reportService;

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products";
    }

    @GetMapping("/stores")
    public String viewStores(Model model) {
        model.addAttribute("stores", storeRepo.findAll());
        return "stores";
    }

    @GetMapping("/regions")
    public String viewRegions(Model model) {
        model.addAttribute("regions", regionRepo.findAll());
        return "regions";
    }

    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("reports", reportService.getAll());
        return "shelf-reports"; // already exists
    }
}
