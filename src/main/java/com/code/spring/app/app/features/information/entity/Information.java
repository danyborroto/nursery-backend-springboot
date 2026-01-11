package com.code.spring.app.app.features.information.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "informations")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Integer id;
    @Column(name = "nursery_name")
    private String nurseryName;
    @Column(name = "description")
    private String description;
    @Column(name = "history")
    private String history;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_primary")
    private String primaryPhone;
    @Column(name = "phone_secondary")
    private String secondaryPhone;
    @Column(name = "email")
    private String email;

    public Information(){}

    public Information(String nurseryName, String description, String history, String address,
                       String primaryPhone, String secondaryPhone, String email) {
        this.nurseryName = nurseryName;
        this.description = description;
        this.history = history;
        this.address = address;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.email = email;
    }

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
