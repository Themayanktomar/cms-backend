package com.example.cms.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Admin")
@Data
public class AdminEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "password")
    private String adminPassword;
}
