package com.example.cms.dto;


import java.time.LocalDate;

public class ClaimServiceResponseDTO {

    private String memberID;
    private String memberFirstName;
    private String memberLastName;
    private String insuranceType;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private LocalDate claimRequestDate;
    private Integer claimRequestNo;
    private String status;
    public Integer getClaimRequestNo() {
        return claimRequestNo;
    }

    public void setClaimRequestNo(Integer claimRequestNo) {
        this.claimRequestNo = claimRequestNo;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public LocalDate getClaimRequestDate() {
        return claimRequestDate;
    }

    public void setClaimRequestDate(LocalDate claimRequestDate) {
        this.claimRequestDate = claimRequestDate;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    private String claimReason ;
}
