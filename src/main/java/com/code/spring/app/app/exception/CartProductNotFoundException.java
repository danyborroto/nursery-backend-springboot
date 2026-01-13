package com.code.spring.app.app.exception;

public class CartProductNotFoundException extends RuntimeException {
    public CartProductNotFoundException(Integer cartId, Integer productId) {
        super("No encontrado carro con ID: " + cartId + " y producto con ID: " + productId);
    }
}
