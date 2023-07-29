package com.onlineShopping.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	private String addressLine1;

	private String addressLine2;

	private String buildingName;

	private String landMark;

	private String city;

	private String state;

	private String country;

	private String pincode;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime addressCreatedDate;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime addressUpdatedDate;

}