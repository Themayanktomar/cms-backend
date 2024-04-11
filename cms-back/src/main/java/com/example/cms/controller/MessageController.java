package com.example.cms.controller;

import com.example.cms.entity.AdminEntity;
import com.example.cms.repository.AdminRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/messages")
    public List<String> getMessages(HttpSession session) {
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    @PostMapping("/messages")
    public void persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        }
        messages.add(msg);
        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam("adminId") String adminId, @RequestParam("password") String password, HttpSession session) {
        Optional<AdminEntity> admin = adminRepository.findById(adminId);
        if (admin.isPresent())
        {
            AdminEntity adminEntity = admin.get();
            if (admin != null  && adminEntity.getAdminPassword().equals(password)) {
                session.setAttribute("ADMIN_ID", adminEntity.getId());
                return true;
            }
        }

        return false;
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
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
