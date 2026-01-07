package com.code.spring.app.app.producto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String nombre;
    @Column(name = "product_price")
    private Double precio;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_count")
    private Integer count;
    @Column(name = "product_height")
    private Double height;
    @Column(name = "product_height_unit")
    private String heightUnit;
    @Column(name = "format_id")
    private Integer formatId;

    public Producto() {
    }

    public Producto(String nombre, Double precio, String description,
                    Integer count, Double height, String heightUnit, Integer formatId) {
        this.nombre = nombre;
        this.precio = precio;
        this.description = description;
        this.count = count;
        this.height = height;
        this.heightUnit = heightUnit;
        this.formatId = formatId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
