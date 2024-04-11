package com.example.cms.controller;

import com.example.cms.dto.MemberDetailsDTO;
import com.example.cms.entity.MemberDetailsEntity;
import com.example.cms.service.MemberDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/members")
public class MemberDetailsController {

    @Autowired
    private MemberDetailsService memberService;

    @PostMapping("/createMember")
    public String createMember(@RequestBody MemberDetailsDTO memberDTO , HttpSession session) {
        return memberService.createMember(memberDTO , session);
    }

    @PostMapping("/updateMember")
    public String updateMember(@RequestBody MemberDetailsDTO memberDTO , HttpSession session) {

        return memberService.updateMember(memberDTO , session);
    }

    @GetMapping("gelAllMember")
    public List<MemberDetailsDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/getById/{memberId}")
    public MemberDetailsDTO getMemberById(@PathVariable String memberId) {
        return memberService.getMemberById(memberId);
    }

    @DeleteMapping("/{memberId}")
    public String deleteMember(@PathVariable String memberId) {
       return memberService.deleteMember(memberId);
    }
}
