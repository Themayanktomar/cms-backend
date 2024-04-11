package com.example.cms.service.impl;

import com.example.cms.dto.MemberDetailsDTO;
import com.example.cms.entity.InsuranceEntity;
import com.example.cms.entity.MemberDetailsEntity;
import com.example.cms.repository.InsuranceRepository;
import com.example.cms.repository.MemberDetailsRepository;
import com.example.cms.service.MemberDetailsService;
import com.example.cms.utility.Utility;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberDetailsServiceImpl implements MemberDetailsService {

    private static int memberCounter = 1;
    @Autowired
    private MemberDetailsRepository memberRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public String createMember(MemberDetailsDTO memberDTO , HttpSession session) {

        String memberID = createMemberID();
        MemberDetailsEntity memberDetailsEntity = copyDtoToEntity(memberDTO);
        memberDetailsEntity.setMemberId(memberID);
        memberDetailsEntity.setCreateAt(LocalDateTime.now());
        memberDetailsEntity.setCreatedBy(Utility.getUserInfo(session));
        memberDetailsEntity.setUpdateAt(LocalDateTime.now());
        memberDetailsEntity.setUpdatedBy(Utility.getUserInfo(session));
        memberRepository.save(memberDetailsEntity);
        return "Member created successfully with memberID :" + memberID;
    }

    private MemberDetailsEntity copyDtoToEntity(MemberDetailsDTO memberDTO) {
        MemberDetailsEntity memberDetailsEntity = new MemberDetailsEntity();

        memberDetailsEntity.setFirstName(memberDTO.getFirstName());
        memberDetailsEntity.setLastName(memberDTO.getLastName());
        memberDetailsEntity.setDateOfBirth(memberDTO.getDateOfBirth());
        memberDetailsEntity.setAddress(memberDTO.getAddress());
        memberDetailsEntity.setContactNo(memberDTO.getContactNo());
        memberDetailsEntity.setEmail(memberDTO.getEmail());
        memberDetailsEntity.setGender(memberDTO.getGender());
        memberDetailsEntity.setNomineeCount(memberDTO.getNomineeCount());
        InsuranceEntity insuranceEntity = insuranceRepository.findByInsuranceType(memberDTO.getInsuranceType());
        memberDetailsEntity.setInsuranceEntity(insuranceEntity);
        return memberDetailsEntity;
    }


    private MemberDetailsDTO copyEntityToDto(MemberDetailsEntity memberDetailsEntity) {
        MemberDetailsDTO memberDTO = new MemberDetailsDTO();

        memberDTO.setMemberId(memberDetailsEntity.getMemberId());
        memberDTO.setFirstName(memberDetailsEntity.getFirstName());
        memberDTO.setLastName(memberDetailsEntity.getLastName());
        memberDTO.setDateOfBirth(memberDetailsEntity.getDateOfBirth());
        memberDTO.setAddress(memberDetailsEntity.getAddress());
        memberDTO.setContactNo(memberDetailsEntity.getContactNo());
        memberDTO.setEmail(memberDetailsEntity.getEmail());
        memberDTO.setGender(memberDetailsEntity.getGender());
        memberDTO.setNomineeCount(memberDetailsEntity.getNomineeCount());
        memberDTO.setInsuranceType(memberDetailsEntity.getInsuranceEntity().getInsuranceType());

        return memberDTO;
    }


    private String createMemberID() {
        String memberID = "MBC-" + String.format("%05d", memberCounter);
        memberCounter++;
        return memberID;
    }
    @Override
    public String updateMember(MemberDetailsDTO memberDTO ,HttpSession session) {
        MemberDetailsEntity memberDetailsEntity = memberRepository.findByMemberId(memberDTO.getMemberId()) ;
        memberDetailsEntity.setFirstName(memberDTO.getFirstName() != null ? memberDTO.getFirstName() : memberDetailsEntity.getFirstName());
        memberDetailsEntity.setLastName(memberDTO.getLastName() != null ? memberDTO.getLastName() : memberDetailsEntity.getLastName());
        memberDetailsEntity.setDateOfBirth(memberDTO.getDateOfBirth() != null ? memberDTO.getDateOfBirth() : memberDetailsEntity.getDateOfBirth());
        memberDetailsEntity.setGender(memberDTO.getGender() != null ? memberDTO.getGender() : memberDetailsEntity.getGender());
        memberDetailsEntity.setAddress(memberDTO.getAddress() != null ? memberDTO.getAddress() : memberDetailsEntity.getAddress());
        memberDetailsEntity.setContactNo(memberDTO.getContactNo() != null ? memberDTO.getContactNo() : memberDetailsEntity.getContactNo());
        memberDetailsEntity.setUpdatedBy(Utility.getUserInfo(session));
        memberDetailsEntity.setUpdateAt(LocalDateTime.now());
        memberRepository.save(memberDetailsEntity);
        return "The member "+ memberDTO.getMemberId() + " successfully updated ";
    }

    @Override
    public List<MemberDetailsDTO> getAllMembers() {
       List<MemberDetailsEntity> memberDetailsEntities = memberRepository.findAll();
       return memberDetailsEntities.stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public MemberDetailsDTO getMemberById(String memberId) {
        MemberDetailsEntity memberDetailsEntity = memberRepository.findByMemberId(memberId);
        return copyEntityToDto(memberDetailsEntity);
    }

    @Override
    public String deleteMember(String memberId) {
      MemberDetailsEntity memberDetailsEntity = memberRepository.findByMemberId(memberId);
      memberRepository.delete(memberDetailsEntity);
      return  " member deleted successfully . ";
    }
}
