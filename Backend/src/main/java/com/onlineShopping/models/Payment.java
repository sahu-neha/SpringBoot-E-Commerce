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
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;

	private String paymentType;

	private Boolean allowed;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime paymentAddedTimeStamp;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime paymentUpdatedTimeStamp;
}