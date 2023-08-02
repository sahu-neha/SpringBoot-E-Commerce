package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
