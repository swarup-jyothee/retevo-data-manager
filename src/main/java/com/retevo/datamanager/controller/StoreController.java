package com.retevo.datamanager.controller;

import com.retevo.datamanager.entity.Store;
import com.retevo.datamanager.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.save(store);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAll();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.delete(id);
    }
}
