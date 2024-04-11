package com.example.cms.repository;

import com.example.cms.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity , String> {

    InsuranceEntity findByInsuranceType(String insuranceType);
}
