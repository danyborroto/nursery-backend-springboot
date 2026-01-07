package com.code.spring.app.app.exception;

public class ProductoNotFounException extends RuntimeException{
    public ProductoNotFounException(Integer id){
        super("Producto no encontrado con id: "+id);
    }
}
