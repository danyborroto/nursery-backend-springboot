package com.code.spring.app.app.features.producto.dto;

import com.code.spring.app.app.features.format.dto.FormatResponseDto;

public class ProductoResponseDto {
    private String nombre;
    private Double precio;
    private String description;
    private Integer count;
    private Double height;
    private String heightUnit;
    private FormatResponseDto format;

    public ProductoResponseDto(String nombre, Double precio, String description,
                               Integer count, Double height, String heightUnit, FormatResponseDto format){
        this.nombre=nombre;
        this.precio=precio;
        this.description = description;
        this.count = count;
        this.height = height;
        this.heightUnit = heightUnit;
        this.format = format;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public Integer getFormatId() {
        return format.getFormatId();
    }

    /* public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    } */

    public void setFormat(FormatResponseDto format){
        this.format = format;
    }
    public FormatResponseDto getFormat(){
        return this.format;
    }
}
