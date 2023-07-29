package com.onlineShopping.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;

	@Lob
	private String customerReview;

	@Max(5)
	@Min(1)
	private Double customerRating;

	@ElementCollection
	private List<Image> images;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime reviewTimeStamp;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Product product;

}
