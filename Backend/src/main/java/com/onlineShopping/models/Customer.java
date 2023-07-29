package com.onlineShopping.models;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String contact;

	@Column(unique = true)
	private String email;

	private String password;

	@Embedded
	private Image image;

	@Past
	private LocalDate dateOfBirth;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime accountCreatedDate;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime accountUpdatedDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> listOfReviews = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> listOfOrders = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<CancelOrderRequest> listOfCancelOrders = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<ReplaceOrderRequest> listOfReplaceOrders = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<RefundOrderRequest> listOfRefunds = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "roleId"))
	private Set<Role> roles = new HashSet<>();

}
