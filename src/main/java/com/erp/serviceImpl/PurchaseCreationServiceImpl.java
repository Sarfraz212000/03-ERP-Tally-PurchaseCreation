package com.erp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.entity.PurchaseCreationEntity;
import com.erp.repo.PurchaseCreationRepo;
import com.erp.service.PurchaseCreationService;

@Service
public class PurchaseCreationServiceImpl implements PurchaseCreationService {

	@Autowired
	private PurchaseCreationRepo repo;

	@Override
	public Boolean savePurchase(PurchaseCreationEntity entity) {
		repo.save(entity);
		return true;
	}

	@Override
	public PurchaseCreationEntity getById(Integer id) {
		Optional<PurchaseCreationEntity> findById = repo.findById(id);

		if (findById.isPresent()) {
			PurchaseCreationEntity entity = findById.get();
			return entity;
		}

		return null;
	}

	@Override
	public String deletePurchaseById(Integer id) {
		repo.deleteById(id);
		return "delete successfully";
	}

	@Override
	public PurchaseCreationEntity updatePurchase(PurchaseCreationEntity entities,Integer purchaseId) {
		Optional<PurchaseCreationEntity> optionalId = repo.findById(purchaseId);
		if (optionalId.isPresent()) {
			PurchaseCreationEntity entity = optionalId.get();
			BeanUtils.copyProperties(entities, entity);
			entity.setPurchaseId(purchaseId);
		    return	repo.save(entity);
			
		}
		return null;
	}

	@Override
	public List<PurchaseCreationEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId) {
		return repo.findAllByCompanyIdAndUserId(companyId, userId);

	}

	@Override
	public List<PurchaseCreationEntity> findByCompanyId(Long companyId) {
		return repo.findAllByCompanyId(companyId);
	}

	@Override
	public List<PurchaseCreationEntity> findByUserId(Long userId) {
		return repo.findAllByUserId(userId);
		
	}

	@Override
	public List<PurchaseCreationEntity> getAllPurchaseCreation() {
		return repo.findAll();
	}

}
