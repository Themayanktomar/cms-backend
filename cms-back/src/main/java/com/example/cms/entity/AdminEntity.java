package com.example.cms.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Admin")
public class AdminEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "password")
    private String adminPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
