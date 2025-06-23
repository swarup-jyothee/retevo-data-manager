package com.retevo.datamanager.service;

import com.retevo.datamanager.entity.Store;
import com.retevo.datamanager.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public Store getById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
