package com.example.cms.service;

import com.example.cms.dto.MemberDetailsDTO;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MemberDetailsService {
    String createMember(MemberDetailsDTO memberDTO , HttpSession session);
    String  updateMember(MemberDetailsDTO memberDTO , HttpSession session);
    List<MemberDetailsDTO> getAllMembers();
    MemberDetailsDTO getMemberById(String memberId);
    String deleteMember(String memberId);


}
