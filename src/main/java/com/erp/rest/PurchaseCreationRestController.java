package com.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.entity.PurchaseCreationEntity;
import com.erp.service.PurchaseCreationService;

@RestController
@RequestMapping("/erptally")
public class PurchaseCreationRestController {

	@Autowired
	private PurchaseCreationService Services;

	@PostMapping("/save")
	public ResponseEntity<String> savePurchase(@RequestBody PurchaseCreationEntity entity) {
		Boolean saveOrder = Services.savePurchase(entity);
		if (saveOrder) {
			return new ResponseEntity<String>("purchase cration save", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("purchase cration not save", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("purchase/{id}")
	public ResponseEntity<PurchaseCreationEntity> getByIdPurchase(@PathVariable Integer id) {
		PurchaseCreationEntity entity = Services.getById(id);

		if (entity != null) {

			return new ResponseEntity<PurchaseCreationEntity>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<PurchaseCreationEntity>(entity, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletePurchaseById(@PathVariable Integer id) {
		String deleteOrder = Services.deletePurchaseById(id);
		return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
	}

	@PutMapping("/update/{purchaseId}")
	public ResponseEntity<PurchaseCreationEntity> updatePurchase(@RequestBody PurchaseCreationEntity entity,
			@PathVariable Integer purchaseId) {
		PurchaseCreationEntity updateOrderDetails = Services.updatePurchase(entity, purchaseId);
		if (updateOrderDetails != null) {
			return new ResponseEntity<>(updateOrderDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateOrderDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("purchase/{companyId}/{userId}")
	public ResponseEntity<List<PurchaseCreationEntity>> findAllPurchaseByCompanyIdOrUserId(@PathVariable Long companyId,
			@PathVariable Long userId) {
		List<PurchaseCreationEntity> entities = Services.findAllByCompanyIdAndUserId(companyId, userId);
		if (!entities.isEmpty()) {
			return new ResponseEntity<List<PurchaseCreationEntity>>(entities, HttpStatus.OK);
		}
		return new ResponseEntity<List<PurchaseCreationEntity>>(entities, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getcompany/{companyId}")
	public ResponseEntity<List<PurchaseCreationEntity>> getByCompanyId(@PathVariable Long companyId) {
		List<PurchaseCreationEntity> entity = Services.findByCompanyId(companyId);
		return new ResponseEntity<List<PurchaseCreationEntity>>(entity, HttpStatus.OK);

	}

	@GetMapping("/getuser/{userId}")
	public ResponseEntity<List<PurchaseCreationEntity>> getByUserId(@PathVariable Long userId) {
		List<PurchaseCreationEntity> entity = Services.findByUserId(userId);
		return new ResponseEntity<List<PurchaseCreationEntity>>(entity, HttpStatus.OK);

	}

	@GetMapping("/getAllpurchases")
	public ResponseEntity<List<PurchaseCreationEntity>> getAllpurchaseCreation() {
		List<PurchaseCreationEntity> allPurchaseCreation = Services.getAllPurchaseCreation();
		return new ResponseEntity<List<PurchaseCreationEntity>>(allPurchaseCreation, HttpStatus.OK);
	}

}
