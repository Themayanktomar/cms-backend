package com.example.cms.repository;

import com.example.cms.dto.LoginRequestDTO;
import jakarta.servlet.http.HttpSession;

public interface AuthenticateService {
    Boolean login(LoginRequestDTO loginRequestDTO , HttpSession session);
    void logout(HttpSession session);
}
