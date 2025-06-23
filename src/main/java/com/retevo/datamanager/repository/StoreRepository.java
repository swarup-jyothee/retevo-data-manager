package com.retevo.datamanager.repository;

import com.retevo.datamanager.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
