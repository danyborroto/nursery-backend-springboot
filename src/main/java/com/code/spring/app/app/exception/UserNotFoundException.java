package com.code.spring.app.app.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id){
        super("Usuario no encontrado con id: "+id);
    }
}
