package com.example.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
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
    private LocalDate approvalDate;

    @Column(name = "Rejection_Reason")
    private String rejectionReason;

    @Column(name = "Final_Claim_Amount")
    private Integer finalClaimAmount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "Amount_Claim_Date")
    private LocalDate amountClaimDate;

    @Column(name = "status")
    private String status;

    public Integer getClaimRequestNo() {
        return claimRequestNo;
    }

    public void setClaimRequestNo(Integer claimRequestNo) {
        this.claimRequestNo = claimRequestNo;
    }

    public MemberDetailsEntity getMemberDetailsEntity() {
        return memberDetailsEntity;
    }

    public void setMemberDetailsEntity(MemberDetailsEntity memberDetailsEntity) {
        this.memberDetailsEntity = memberDetailsEntity;
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

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Integer getFinalClaimAmount() {
        return finalClaimAmount;
    }

    public void setFinalClaimAmount(Integer finalClaimAmount) {
        this.finalClaimAmount = finalClaimAmount;
    }

    public LocalDate getAmountClaimDate() {
        return amountClaimDate;
    }

    public void setAmountClaimDate(LocalDate amountClaimDate) {
        this.amountClaimDate = amountClaimDate;
    }
}
