package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
