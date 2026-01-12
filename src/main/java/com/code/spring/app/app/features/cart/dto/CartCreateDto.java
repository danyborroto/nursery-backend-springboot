package com.code.spring.app.app.features.cart.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartCreateDto {
    @Positive(message = "El usuario no puede ser menor que 0")
    @NotNull(message = "El usuario es obligatorio")
    private Integer userId;
    private Boolean active;

    public CartCreateDto(){}

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive(){
        return this.active;
    }
}
