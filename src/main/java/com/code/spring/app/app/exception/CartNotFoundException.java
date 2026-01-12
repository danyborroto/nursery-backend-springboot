package com.code.spring.app.app.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Integer id){
        super("Cart no encontrado con ID: "+ id);
    }
}
