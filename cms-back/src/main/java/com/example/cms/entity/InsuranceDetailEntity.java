package com.example.cms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insurance_detail_entity")
public class InsuranceDetailEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Insurance_Id")
    private Integer insuranceId;

    @Column(name = "Insurance_Type")
    private String insuranceType;

    @Column(name = "Insurance_Amount")
    private Integer insuranceAmount;

    @Column(name = "Maximum_Claimable_Amount")
    private Integer maximumClaimableAmount;

    @ManyToOne(targetEntity = MemberDetailsEntity.class,optional = false,  fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id",referencedColumnName = "member_id", insertable = true, updatable = true)
    private MemberDetailsEntity memberDetailsEntity;

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Integer insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Integer getMaximumClaimableAmount() {
        return maximumClaimableAmount;
    }

    public void setMaximumClaimableAmount(Integer maximumClaimableAmount) {
        this.maximumClaimableAmount = maximumClaimableAmount;
    }

    public MemberDetailsEntity getMemberDetailsEntity() {
        return memberDetailsEntity;
    }

    public void setMemberDetailsEntity(MemberDetailsEntity memberDetailsEntity) {
        this.memberDetailsEntity = memberDetailsEntity;
    }
}
