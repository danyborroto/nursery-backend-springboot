package com.code.spring.app.app.producto.dto;

public class ProductoResponseDto {
    private String nombre;
    private Double precio;
    private String description;
    private Integer count;
    private Double height;
    private String heightUnit;
    private Integer formatId;

    public ProductoResponseDto(String nombre, Double precio, String description,
                               Integer count, Double height, String heightUnit, Integer formatId){
        this.nombre=nombre;
        this.precio=precio;
        this.description = description;
        this.count = count;
        this.height = height;
        this.heightUnit = heightUnit;
        this.formatId = formatId;
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
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }
}
