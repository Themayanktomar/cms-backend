package com.example.cms.service.impl;

import com.example.cms.dto.LoginRequestDTO;
import com.example.cms.entity.AdminEntity;
import com.example.cms.repository.AdminRepository;
import com.example.cms.repository.AuthenticateService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private final AdminRepository adminRepository;

    public AuthenticateServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Boolean login(LoginRequestDTO loginRequestDTO, HttpSession session) {
        Optional<AdminEntity> admin = adminRepository.findById(loginRequestDTO.getAdminId());
        if (admin.isPresent()) {
            AdminEntity adminEntity = admin.get();
            if (adminEntity.getAdminPassword().equals(loginRequestDTO.getPassword())) {
                session.setAttribute("ADMIN_ID", adminEntity.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
