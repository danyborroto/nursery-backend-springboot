package com.code.spring.app.app.features.information.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class InformationCreateDto {
    @NotBlank(message = "El nombre del nursery es obligatorio")
    private String nurseryName;
    @NotBlank(message = "La descripción es obligatorio")
    private String description;
    @NotBlank(message = "La historia es obligatorio")
    private String history;
    @NotBlank(message = "La dirección es obligatorio")
    private String address;
    @NotBlank(message = "El telefono principal es obligatorio")
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    )
    private String primaryPhone;
    @NotBlank(message = "El telefono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    )
    private String secondaryPhone;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    private String email;

    public String getNurseryName() {
        return nurseryName;
    }

    public void setNurseryName(String nurseryName) {
        this.nurseryName = nurseryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
