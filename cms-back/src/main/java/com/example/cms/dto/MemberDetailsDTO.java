package com.example.cms.dto;

import lombok.Data;

import java.time.LocalDate;


public class MemberDetailsDTO {

    private String memberId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private Long contactNo;
    private String email;
    private String gender;
    private int nomineeCount;
    private String insuranceType ;
    private Integer maxClaimAmount;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNomineeCount() {
        return nomineeCount;
    }

    public void setNomineeCount(int nomineeCount) {
        this.nomineeCount = nomineeCount;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getMaxClaimAmount() {
        return maxClaimAmount;
    }

    public void setMaxClaimAmount(Integer maxClaimAmount) {
        this.maxClaimAmount = maxClaimAmount;
    }
}
