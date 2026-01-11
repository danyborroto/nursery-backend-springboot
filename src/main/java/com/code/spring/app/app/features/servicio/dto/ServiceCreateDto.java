package com.code.spring.app.app.features.servicio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;


public class ServiceCreateDto {
    @NotBlank(message = "El nombre no puede ser vacio")
    private String serviceName;
    @NotNull(message = "El campo no puede ser nulo")
    private Boolean selecteable;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getSelecteable() {
        return selecteable;
    }

    public void setSelecteable(Boolean selecteable) {
        this.selecteable = selecteable;
    }
}
