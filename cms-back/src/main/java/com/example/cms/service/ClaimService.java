package com.example.cms.service;

import com.example.cms.dto.ClaimRequestDTO;
import com.example.cms.dto.ClaimServiceResponseDTO;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

public interface ClaimService {

    List<ClaimServiceResponseDTO> getAllClaimsByMemberId(String memberId);
    List<ClaimServiceResponseDTO> getAllClaimsByFirstName(String firstName);
    List<ClaimServiceResponseDTO> getAllClaimsByDateRange(LocalDate startDate , LocalDate endDate);
    String createClaimRequest(ClaimRequestDTO claimRequestDTO , HttpSession session);
    String approveClaimRequest(Integer claimRequestNo);
    String rejectClaimRequest(Integer claimRequestNo , String reason);
}
