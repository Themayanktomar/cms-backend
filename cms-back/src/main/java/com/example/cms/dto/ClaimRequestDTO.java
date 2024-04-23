package com.example.cms.dto;


import java.time.LocalDate;

public class ClaimRequestDTO {

    private String memberId;

    private Integer nomineeCount;
    private Integer maxClaimAmount;

    private String insuranceType;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getNomineeCount() {
        return nomineeCount;
    }

    public void setNomineeCount(Integer nomineeCount) {
        this.nomineeCount = nomineeCount;
    }

    public Integer getMaxClaimAmount() {
        return maxClaimAmount;
    }

    public void setMaxClaimAmount(Integer maxClaimAmount) {
        this.maxClaimAmount = maxClaimAmount;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public Integer getFinalClainAmount() {
        return finalClainAmount;
    }

    public void setFinalClainAmount(Integer finalClainAmount) {
        this.finalClainAmount = finalClainAmount;
    }

    private LocalDate requestDate;
    private String claimReason;
    private Integer finalClainAmount;

}
