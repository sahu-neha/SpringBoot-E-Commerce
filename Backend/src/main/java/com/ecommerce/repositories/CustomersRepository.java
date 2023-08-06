package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

  Customers findByEmail(String email);

}
