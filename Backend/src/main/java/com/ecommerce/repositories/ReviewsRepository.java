package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
