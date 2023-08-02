package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.models.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
