package com.code.spring.app.app.exception;

public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(Integer id){
        super("Información no encontrada con ID: "+id);
    }
}
