package com.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.PurchaseCreationEntity;

public interface PurchaseCreationRepo extends JpaRepository<PurchaseCreationEntity, Integer>{

}
