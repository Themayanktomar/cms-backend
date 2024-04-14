package com.example.cms.service.impl;

import com.example.cms.entity.InsuranceEntity;
import com.example.cms.repository.InsuranceRepository;
import com.example.cms.service.InsuranceService;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Integer getInsuranceAmount(String insuranceType) {
        InsuranceEntity insuranceEntity = insuranceRepository.findByInsuranceType(insuranceType);

        return insuranceEntity.getInsuranceAmount();
    }
}
