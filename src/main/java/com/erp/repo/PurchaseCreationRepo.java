package com.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.PurchaseCreationEntity;

public interface PurchaseCreationRepo extends JpaRepository<PurchaseCreationEntity, Integer>{
	
	public List<PurchaseCreationEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId);

}
