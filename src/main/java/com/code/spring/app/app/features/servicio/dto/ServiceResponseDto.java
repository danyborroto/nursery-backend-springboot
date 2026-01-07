package com.code.spring.app.app.features.servicio.dto;

public class ServiceResponseDto {
    private String serviceName;
    private Boolean selecteable;

    public ServiceResponseDto(String name, Boolean selecteable) {
        this.serviceName = name;
        this.selecteable = selecteable;
    }

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
