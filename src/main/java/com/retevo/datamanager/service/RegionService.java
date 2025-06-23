package com.retevo.datamanager.service;

import com.retevo.datamanager.entity.Region;
import com.retevo.datamanager.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Region getById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        regionRepository.deleteById(id);
    }
}
