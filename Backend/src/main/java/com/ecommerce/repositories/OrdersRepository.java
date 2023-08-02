package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
