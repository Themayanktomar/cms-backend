package com.example.cms.controller;


import com.example.cms.dto.ClaimRequestDTO;
import com.example.cms.dto.ClaimServiceResponseDTO;
import com.example.cms.service.ClaimService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/claim")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping("/getAllClaimsByMemberId/{memberId}")
    public List<ClaimServiceResponseDTO> getAllClaimsByMemberId(@PathVariable String memberId) {

        return claimService.getAllClaimsByMemberId(memberId);
    }

    @GetMapping("/getAllClaimsByFirstName/{firstName}")
    public List<ClaimServiceResponseDTO> getAllClaimsByFirstName(@PathVariable String firstName) {

        return claimService.getAllClaimsByFirstName(firstName);
    }

    @GetMapping("/getAllClaimsByDateRange/{startDate}/{endDate}")
    public  List<ClaimServiceResponseDTO> getAllClaimsByDateRange(@PathVariable LocalDate startDate ,@PathVariable LocalDate endDate){
        return claimService.getAllClaimsByDateRange(startDate,endDate);
    }

    @PostMapping("/createClaim")
    public String createClaimRequest(@RequestBody ClaimRequestDTO claimRequestDTO , HttpSession session)
    {
        return claimService.createClaimRequest(claimRequestDTO , session);
    }
}

