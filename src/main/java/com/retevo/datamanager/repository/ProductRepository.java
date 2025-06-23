package com.retevo.datamanager.repository;

import com.retevo.datamanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
