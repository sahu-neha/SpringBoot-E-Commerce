package com.onlineShopping.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CancelOrderRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cancelOrderRequestId;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime cancelTimeStamp;

	private Boolean isOrderCancelled;

	private Boolean isOrderRefunded;

	private String status;

	@OneToOne
	private Order order;

	@OneToOne
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	private RefundOrderRequest refundOrderRequest;

}