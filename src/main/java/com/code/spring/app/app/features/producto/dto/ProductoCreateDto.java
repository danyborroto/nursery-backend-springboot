package com.code.spring.app.app.features.producto.dto;

import jakarta.validation.constraints.*;

public class ProductoCreateDto {
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @PositiveOrZero(message = "El precio no puede ser menor que 0")
    private Double precio;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String description;
    @PositiveOrZero(message = "La cantidad no puede ser menor que 0")
    private Integer count;
    @Min(value=0, message = "La altura no puede ser menor que 0")
    private Double height;
    @NotBlank(message = "La unidad de altura no puede ser vacia")
    private String heightUnit;
    @Positive(message = "El id de formato no puede ser menor que 0")
    @NotNull(message = "El id de formato no puede ser nulo")
    private Integer formatId;

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
