package com.ecommerce.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@NotBlank(message = "Product name is required")
	@Size(max = 200, message = "Product name cannot exceed 200 characters")
	@Column(nullable = false)
	private String productName;

	@NotBlank(message = "Product description is required")
	@Size(max = 500, message = "Product description cannot exceed 200 characters")
	@Column(nullable = false)
	private String description;

	@NotBlank(message = "Product brand is required")
	@Size(max = 100, message = "Product brand cannot exceed 200 characters")
	@Column(nullable = false)
	private String brand;

	@NotBlank(message = "Product image is required")
	@Column(nullable = false)
	private List<String> imageURL;

	@NotBlank(message = "Product quantity is required")
	@Size(min = 5, message = "Enter product quanity must be 5 or greater")
	@Column(nullable = false)
	private Integer productQuantity;

	@NotBlank(message = "Product price is required")
	@Column(nullable = false)
	@Positive(message = "Price must be positive")
	private Double marketPrice;

	@NotBlank(message = "Product price is required")
	@Column(nullable = false)
	@Positive(message = "Price must be positive")
	private Double sellingPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date dateEntered;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateUpdated;

	@ManyToOne
	@NotBlank(message = "Product type is required")
	private SubCategory subCategory;

	@ManyToOne
	@JoinColumn(name = "category", nullable = false)
	private Category category;

	@ManyToOne
	private Orders orders;

	@ManyToOne
	private Cart cartItems;

	@OneToMany(mappedBy = "product")
	private Reviews reviews;
	
	@ManyToOne
	private Wishlist wishlist;

}
