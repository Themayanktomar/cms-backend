package com.example.cms.controller;

import com.example.cms.dto.MemberDetailsDTO;
import com.example.cms.service.InsuranceService;
import com.example.cms.service.MemberDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/members")
public class MemberDetailsController {


    private final MemberDetailsService memberService;
    private final InsuranceService insuranceService;

    public MemberDetailsController(MemberDetailsService memberService, InsuranceService insuranceService) {
        this.memberService = memberService;
        this.insuranceService = insuranceService;
    }

    @PostMapping("/createMember")
    public String createMember(@RequestBody MemberDetailsDTO memberDTO , HttpSession session) {
        return memberService.createMember(memberDTO , session);
    }

    @PostMapping("/updateMember")
    public String updateMember(@RequestBody MemberDetailsDTO memberDTO , HttpSession session) {

        return memberService.updateMember(memberDTO , session);
    }

    @GetMapping("getAllMember")
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

    @GetMapping("/getInsuranceAmount/{insuranceAmount}")
    public Integer getInsuranceAmount(@PathVariable String insuranceAmount)
    {
        return insuranceService.getInsuranceAmount(insuranceAmount);
    }
}
