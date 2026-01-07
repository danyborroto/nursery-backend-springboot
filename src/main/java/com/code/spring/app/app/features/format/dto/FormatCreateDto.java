package com.code.spring.app.app.features.format.dto;

import jakarta.validation.constraints.NotBlank;

public class FormatCreateDto {
    @NotBlank(message = "El id no puede estar vacio")
    private String formatName;

    public void setName(String name){
        this.formatName = name;
    }
    public String getName(){
        return this.formatName;
    }
}
