package com.code.spring.app.app.features.cartproducto.repository;

import com.code.spring.app.app.features.cartproducto.entity.CartProduct;
import com.code.spring.app.app.features.cartproducto.entity.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductId> {
    List<CartProduct> findByCart_CartId(Integer cartId);

    boolean existsByCart_CartIdAndProducto_ProductId(Integer cartId, Integer productId);

    void deleteByCart_CartIdAndProducto_ProductId(Integer cartId, Integer productId);
}
