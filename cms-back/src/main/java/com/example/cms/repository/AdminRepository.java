package com.example.cms.repository;

import com.example.cms.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

//    AdminEntity findByAdminId(String adminId);
}
