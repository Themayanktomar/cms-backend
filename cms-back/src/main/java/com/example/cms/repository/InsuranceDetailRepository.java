package com.example.cms.repository;

import com.example.cms.entity.InsuranceDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceDetailRepository extends JpaRepository<InsuranceDetailEntity , Integer> {
}
