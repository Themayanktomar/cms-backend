package com.example.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claim_entity")
public class ClaimEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id" )
    private Integer claimId;

    @ManyToOne(targetEntity = MemberDetailsEntity.class,optional = false,  fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id",referencedColumnName = "member_id", insertable = true, updatable = true)
    private MemberDetailsEntity memberDetailsEntity;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @ManyToOne(targetEntity = InsuranceEntity.class,optional = false,  fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_type",referencedColumnName = "insurance_type", insertable = true, updatable = true)
    private InsuranceEntity insuranceEntity;
    @Column(name = "claim_reason")
    private String claimReason;

    @Column(name = "field")
    private String field;
}
