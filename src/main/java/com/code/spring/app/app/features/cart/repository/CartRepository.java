package com.code.spring.app.app.features.cart.repository;

import com.code.spring.app.app.features.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {
}
