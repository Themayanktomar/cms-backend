package com.example.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insurance_entity")
public class InsuranceEntity {

    @Id
    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "insurance_amount")
    private Double insuranceAmount;

}
