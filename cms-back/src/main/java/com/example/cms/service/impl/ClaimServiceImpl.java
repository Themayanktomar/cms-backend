package com.example.cms.service.impl;

import com.example.cms.dto.ClaimServiceResponseDTO;
import com.example.cms.entity.ClaimEntity;
import com.example.cms.entity.MemberDetailsEntity;
import com.example.cms.repository.ClaimRepository;
import com.example.cms.repository.MemberDetailsRepository;
import com.example.cms.service.ClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
//            claimServiceResponseDTO.setInsuranceType(claimentity.getMemberDetailsEntity().getInsuranceEntity().getInsuranceType());
            claimServiceResponseDTOList.add(claimServiceResponseDTO);
        }
        return claimServiceResponseDTOList;
    }
}
