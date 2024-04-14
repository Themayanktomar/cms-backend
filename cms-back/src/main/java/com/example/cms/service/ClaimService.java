package com.example.cms.service;

import com.example.cms.dto.ClaimServiceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ClaimService {

    List<ClaimServiceResponseDTO> getAllClaimsByMemberId(String memberId);
    List<ClaimServiceResponseDTO> getAllClaimsByFirstName(String firstName);
    List<ClaimServiceResponseDTO> getAllClaimsByDateRange(LocalDate startDate , LocalDate endDate);
}
