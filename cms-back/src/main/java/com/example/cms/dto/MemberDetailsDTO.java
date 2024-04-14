package com.example.cms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
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

}
