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
@Table(name = "Member_Details")
public class MemberDetailsEntity extends  Auditable{

    @Id
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_number")
    private Long contactNo;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "nominee_count")
    private int nomineeCount;
    @Column(name = "insurance_type")
    private String insuranceType;
    @Column(name = "insurance_amount")
    private Integer insuranceAmount;
    @Column(name = "claim_amount")
    private Double claimAmount;

//    @ManyToOne(targetEntity = InsuranceEntity.class,optional = false,  fetch = FetchType.EAGER)
//    @JoinColumn(name = "insurance_type",referencedColumnName = "insurance_type", insertable = true, updatable = true)
//    private InsuranceEntity insuranceEntity;
}

