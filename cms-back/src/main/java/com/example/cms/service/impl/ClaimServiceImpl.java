package com.example.cms.service.impl;

import com.example.cms.commons.InsuranceType;
import com.example.cms.dto.ClaimRequestDTO;
import com.example.cms.dto.ClaimServiceResponseDTO;
import com.example.cms.entity.ClaimEntity;
import com.example.cms.entity.MemberDetailsEntity;
import com.example.cms.repository.ClaimRepository;
import com.example.cms.repository.MemberDetailsRepository;
import com.example.cms.service.ClaimService;
import com.example.cms.utility.Utility;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {


    private final MemberDetailsRepository memberDetailsRepository;
    private final ClaimRepository claimRepository;

    public ClaimServiceImpl(MemberDetailsRepository memberDetailsRepository, ClaimRepository claimRepository) {
        this.memberDetailsRepository = memberDetailsRepository;
        this.claimRepository = claimRepository;
    }

    @Override
    public List<ClaimServiceResponseDTO> getAllClaimsByMemberId(String memberId) {

        MemberDetailsEntity memberDetailsEntity= memberDetailsRepository.findByMemberId(memberId);
        List<ClaimEntity> claimEntityList =  claimRepository.findAllByMemberDetailsEntity(memberDetailsEntity);
        return prepareResponseDTO(claimEntityList);

    }

    @Override
    public List<ClaimServiceResponseDTO> getAllClaimsByFirstName(String firstName) {
        List<ClaimServiceResponseDTO> claimServiceResponseDTOS = new ArrayList<>();
        List<MemberDetailsEntity> memberDetailsEntities = memberDetailsRepository.findByFirstName(firstName);
        for (MemberDetailsEntity member:memberDetailsEntities
             ) {
            List<ClaimEntity> claimEntityList =  claimRepository.findAllByMemberDetailsEntity(member);
            List<ClaimServiceResponseDTO> claimServiceResponseDTOList = prepareResponseDTO(claimEntityList);
            claimServiceResponseDTOS.addAll(claimServiceResponseDTOList);
        }
        return claimServiceResponseDTOS;

    }

    @Override
    public List<ClaimServiceResponseDTO> getAllClaimsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<ClaimEntity> claimEntityList = claimRepository.findAllByRequestDateBetween(startDate , endDate);
        return prepareResponseDTO(claimEntityList);
    }

    @Override
    public String createClaimRequest(ClaimRequestDTO claimRequestDTO , HttpSession session) {
        ClaimEntity claimEntity = new ClaimEntity();
        MemberDetailsEntity memberDetailsEntity = memberDetailsRepository.findByMemberId(claimRequestDTO.getMemberId());
        claimEntity.setMemberDetailsEntity(memberDetailsEntity);
        claimEntity.setClaimReason(claimRequestDTO.getClaimReason());
        claimEntity.setRequestDate(LocalDate.now());
        claimEntity.setAmountClaimDate(LocalDate.now().plusDays(45));
        claimEntity.setFinalClaimAmount(getFinalClaimAmount(memberDetailsEntity , claimRequestDTO));
        claimEntity.setCreateAt(LocalDateTime.now());
        claimEntity.setCreatedBy(Utility.getUserInfo(session));
        claimEntity.setUpdateAt(LocalDateTime.now());
        claimEntity.setUpdatedBy(Utility.getUserInfo(session));

        ClaimEntity savedEntity = claimRepository.save(claimEntity);

        return "Dear Admin the claim request for " + memberDetailsEntity.getMemberId() + " has been posted , your claim will be processed before " + savedEntity.getAmountClaimDate();
     }

    private Integer getFinalClaimAmount(MemberDetailsEntity memberDetailsEntity , ClaimRequestDTO claimRequestDTO) {
        Integer finalClaimAmount = null;
        switch (memberDetailsEntity.getInsuranceType())
        {
            case "CAR_INSURANCE":
                switch (claimRequestDTO.getClaimReason())
                {
                    case "Repair":
                        finalClaimAmount = (int) (40%100* memberDetailsEntity.getClaimAmount());
                        break;
                    case "Stolen":
                        finalClaimAmount = (int) (70%100* memberDetailsEntity.getClaimAmount());
                        break;
                }
                break;
            case "HOME_INSURANCE":
                switch (claimRequestDTO.getClaimReason())
                {
                    case "Renovate":
                        finalClaimAmount = (int) (50%100* memberDetailsEntity.getClaimAmount());
                        break;
                    case "Destroyed":
                        finalClaimAmount = (int) (70%100* memberDetailsEntity.getClaimAmount());
                        break;
                }
                break;

            case "LIFE_INSURANCE":
                switch (claimRequestDTO.getClaimReason())
                {
                    case "Treatment Claim":
                        finalClaimAmount = (int) (5%100* memberDetailsEntity.getClaimAmount());
                        break;
                    case "Death Claim":
                        finalClaimAmount = (int) (1%100* memberDetailsEntity.getClaimAmount());
                        break;
                }
                break;
        }
        return finalClaimAmount;

    }


    private List<ClaimServiceResponseDTO> prepareResponseDTO(List<ClaimEntity> claimEntityList) {
        List<ClaimServiceResponseDTO> claimServiceResponseDTOList = new ArrayList<>();

        for (ClaimEntity claimentity: claimEntityList
             ) {
            ClaimServiceResponseDTO claimServiceResponseDTO = new ClaimServiceResponseDTO();
            claimServiceResponseDTO.setClaimRequestDate(claimentity.getRequestDate());
            claimServiceResponseDTO.setClaimReason(claimentity.getClaimReason());
            claimServiceResponseDTO.setMemberID(claimentity.getMemberDetailsEntity().getMemberId());
            claimServiceResponseDTO.setMemberFirstName(claimentity.getMemberDetailsEntity().getFirstName());
            claimServiceResponseDTO.setMemberLastName(claimentity.getMemberDetailsEntity().getLastName());
            claimServiceResponseDTO.setClaimRequestNo(claimentity.getClaimRequestNo());
            claimServiceResponseDTO.setInsuranceType(claimentity.getMemberDetailsEntity().getInsuranceType());
            claimServiceResponseDTO.setStatus(claimentity.getStatus());
            claimServiceResponseDTOList.add(claimServiceResponseDTO);
        }
        return claimServiceResponseDTOList;
    }


    @Override
    public String rejectClaimRequest(Integer claimRequestNo, String reason) {
        ClaimEntity claimEntity = claimRepository.findByClaimRequestNo(claimRequestNo);
        claimEntity.setRejectionReason(reason);
        claimEntity.setStatus("Rejected");
        ClaimEntity savedEntity = claimRepository.save(claimEntity);
        return "Claim rejected successfully";
    }

    @Override
    public String approveClaimRequest(Integer claimRequestNo) {
        ClaimEntity claimEntity = claimRepository.findByClaimRequestNo(claimRequestNo);
        claimEntity.setApprovalDate(claimEntity.getAmountClaimDate().plusDays(10));
        claimEntity.setStatus("Approved");
        ClaimEntity savedEntity = claimRepository.save(claimEntity);
        return "Your claim request is approved claim amount is " + savedEntity.getFinalClaimAmount() + " and the claim approval date is " + savedEntity.getApprovalDate() ;
    }
}
