package com.erp.service;

import java.util.List;

import com.erp.entity.PurchaseCreationEntity;

public interface PurchaseCreationService {

	public Boolean savePurchase(PurchaseCreationEntity entity);

	public PurchaseCreationEntity getById(Integer id);

	public String deletePurchaseById(Integer id);

	public PurchaseCreationEntity updatePurchase(PurchaseCreationEntity entities);
	
	public List<PurchaseCreationEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId);

}
