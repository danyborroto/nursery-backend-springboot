package com.code.spring.app.app.features.cart.dto;

import com.code.spring.app.app.features.user.dto.UserResponseDto;

public class CartResponseDto {
    private UserResponseDto user;
    private Boolean active;

    public CartResponseDto() {
    }

    public CartResponseDto(UserResponseDto user, Boolean active) {
        this.user = user;
        this.active = active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean isActive) {
        this.active = isActive;
    }

    public UserResponseDto getUser() {
        return this.user;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }
}
