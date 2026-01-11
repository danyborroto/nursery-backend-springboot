package com.code.spring.app.app.features.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserCreateDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String userName;
    @NotBlank(message = "El password es obligatorio")
    @Size(min = 8)
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).*$",
            message = "Debe tener mayúscula, minúscula y número"
    )
    private String userPassword;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    private String userEmail;
    @NotBlank(message = "El telefono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{9,15}$",
            message = "El teléfono debe contener entre 9 y 15 dígitos"
    )
    private String userPhone;
    private Boolean admin;

    public UserCreateDto(String userName, String userPassword, String userEmail, String userPhone, Boolean admin) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.admin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
