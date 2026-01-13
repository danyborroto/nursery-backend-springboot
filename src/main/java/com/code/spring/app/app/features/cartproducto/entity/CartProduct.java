package com.code.spring.app.app.features.cartproducto.entity;

import com.code.spring.app.app.features.cart.entity.Cart;
import com.code.spring.app.app.features.producto.entity.Producto;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {

    @EmbeddedId
    private CartProductId id;
    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Producto producto;

    @Column(name = "price")
    private Double price;
    @Column(name = "count")
    private Integer count;

    public CartProduct() {
    }

    public CartProduct(Cart cart, Producto producto, Double price, Integer count) {
        this.cart = cart;
        this.producto = producto;
        this.price = price;
        this.count = count;
        this.id = new CartProductId(cart.getCartId(), producto.getId());
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartProductId getId() {
        return id;
    }

    public void setId(CartProductId id) {
        this.id = id;
    }
}
