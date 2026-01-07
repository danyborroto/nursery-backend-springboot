package com.code.spring.app.app.exception;

public class FormatNotFoundException extends RuntimeException {
    public FormatNotFoundException(Integer id) {
        super("Formato no encontrado con ID: " + id);
    }
}
