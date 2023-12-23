package com.erp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "PURCHASE_CREATION_TAB")
public class PurchaseCreationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseId;

	private String orderNo;

	private String partyName;

	private Long currentBalance;

	private String itemName;

	private String quantity;

	private Double rate;

	private String unit;

	private String discount;

	private Long amount;

	private String description;

	@CreationTimestamp
	private LocalDateTime date;

	private String days;

	private Long userId;

	private Long compid;
}
