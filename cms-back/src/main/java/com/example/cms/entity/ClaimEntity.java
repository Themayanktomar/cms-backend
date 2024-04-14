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
public class ClaimEntity  extends Auditable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Claim_Request_no" )
    private Integer claimRequestNo;

    @ManyToOne(targetEntity = MemberDetailsEntity.class,optional = false,  fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id",referencedColumnName = "member_id", insertable = true, updatable = true)
    private MemberDetailsEntity memberDetailsEntity;

    @Column(name = "Request_date")
    private LocalDate requestDate;

    @Column(name = "claim_reason")
    private String claimReason;

    @Column(name = "Approval_Date")
    private String approvalDate;

    @Column(name = "Rejection_Reason")
    private String rejectionReason;

    @Column(name = "Final_Claim_Amount")
    private Integer finalClaimAmount;

    @Column(name = "Amount_Claim_Date")
    private LocalDate amountClaimDate;

}
