//package com.example.cms.controller;
//
//
//
//import com.example.cms.dto.AdminDTO;
//import com.example.cms.entity.AdminEntity;
//import com.example.cms.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@SessionAttributes("admin")
//@RestController
//public class AdminController {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @GetMapping("/admin")
//    public String adminPage() {
//        return "admin";
//    }
//
//    @PostMapping("/admin/login")
//    public Boolean loginAdmin(@ModelAttribute("admin") AdminEntity adminEntity, Model model) {
//        String adminId = adminEntity.getAdminId();
//        String password = adminEntity.getAdminPassword();
//
//        AdminEntity storedAdmin = adminRepository.findById(adminId).orElse(null);
//        if (storedAdmin != null && passwordEncoder.matches(password, storedAdmin.getAdminPassword())) {
//            // Password matches, proceed with authentication
//            model.addAttribute("admin", storedAdmin);
//           return true
//        } else {
//            // Password does not match, show error message
//            model.addAttribute("error", "Invalid admin ID or password");
//          return false
//        }
//    }
//}
