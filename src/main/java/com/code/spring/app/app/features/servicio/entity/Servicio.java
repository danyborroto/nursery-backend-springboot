package com.code.spring.app.app.features.servicio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "selecteable")
    private Boolean selecteable;
    public Servicio(){}

    public Servicio(String formatName, Boolean selecteable){
        this.serviceName = formatName;
        this.selecteable = selecteable;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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
