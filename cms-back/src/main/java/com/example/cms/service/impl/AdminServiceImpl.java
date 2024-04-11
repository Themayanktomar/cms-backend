//package com.example.cms.service.impl;
//
//import com.example.cms.dto.AdminDTO;
//import com.example.cms.entity.AdminEntity;
//import com.example.cms.repository.AdminRepository;
//import com.example.cms.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class AdminServiceImpl implements AdminService {
//    @Autowired
//    private AdminRepository adminRepository;
//    @Override
//    public Boolean login(AdminDTO adminDTO) {
//        AdminEntity adminEntity = adminRepository.findByAdminId(adminDTO.getAdminId());
//        return adminEntity.getAdminId().equalsIgnoreCase(adminDTO.getAdminId()) && adminEntity.getAdminPassword().equalsIgnoreCase(adminDTO.getPassword());
//    }
//}
