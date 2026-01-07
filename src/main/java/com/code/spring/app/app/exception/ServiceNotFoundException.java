package com.code.spring.app.app.exception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(Integer id) {
        super("Servicio no encontrado con ID: " + id);
    }
}
