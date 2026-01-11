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

    public @NotBlank(message = "El nombre del nursery es obligatorio") String getNurseryName() {
        return nurseryName;
    }

    public void setNurseryName(@NotBlank(message = "El nombre del nursery es obligatorio") String nurseryName) {
        this.nurseryName = nurseryName;
    }

    public @NotBlank(message = "La descripción es obligatorio") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "La descripción es obligatorio") String description) {
        this.description = description;
    }

    public @NotBlank(message = "La historia es obligatorio") String getHistory() {
        return history;
    }

    public void setHistory(@NotBlank(message = "La historia es obligatorio") String history) {
        this.history = history;
    }

    public @NotBlank(message = "La dirección es obligatorio") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "La dirección es obligatorio") String address) {
        this.address = address;
    }

    public @NotBlank(message = "El telefono principal es obligatorio") @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    ) String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(@NotBlank(message = "El telefono principal es obligatorio") @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    ) String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public @NotBlank(message = "El telefono es obligatorio") @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    ) String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(@NotBlank(message = "El telefono es obligatorio") @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    ) String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public @NotBlank(message = "El email es obligatorio") @Email(message = "El email no tiene un formato valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es obligatorio") @Email(message = "El email no tiene un formato valido") String email) {
        this.email = email;
    }
}
