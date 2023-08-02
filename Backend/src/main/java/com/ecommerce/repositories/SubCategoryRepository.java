package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

}
