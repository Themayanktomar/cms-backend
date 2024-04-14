package com.example.cms.controller;

import com.example.cms.dto.LoginRequestDTO;
import com.example.cms.repository.AdminRepository;
import com.example.cms.repository.AuthenticateService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api")
public class AunthenticateController {



    private final AdminRepository adminRepository;
    private final AuthenticateService authenticateService;
    public AunthenticateController(AdminRepository adminRepository, AuthenticateService authenticateService) {
        this.adminRepository = adminRepository;
        this.authenticateService = authenticateService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequestDTO loginRequestDTO, HttpSession session) {
        return  authenticateService.login(loginRequestDTO , session);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        authenticateService.logout(session);
    }


    @GetMapping("/userinfo")
    public String getUserInfo(HttpSession session) {
        String adminId = (String) session.getAttribute("ADMIN_ID");

        if (adminId != null) {
            return "Logged in adminId: " + adminId;
        } else {
            return "User not logged in";
        }
    }
}
