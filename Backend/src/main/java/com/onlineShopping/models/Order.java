package com.onlineShopping.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	// Ordered //Dispatched //Shipped //Delivered //Cancelled //
	private String orderStatus;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime orderTimeStamp;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime orderUpdatedTimeStamp;

	private LocalDateTime expectedDeliveryDate;

	private Integer orderQuantity;

	private Double orderTotalAmount;

	@OneToOne
	private Payment payment;

	@ManyToOne
	private Customer customer;

	@ElementCollection
	private List<OrderProductDetails> listOfProducts = new ArrayList<>();

	private Boolean isOrderCancelled;

	private Boolean isOrderReturned;

	private Boolean isOrderReplaced;

	private Boolean isOrderRefunded;

	private Boolean isOrderDelievered;

	private Boolean isReplacementOrder;

	private Integer orginialOrderId;

}