package com.example.cms.repository;

import com.example.cms.entity.ClaimEntity;
import com.example.cms.entity.MemberDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity , Integer> {

    List<ClaimEntity> findAllByMemberDetailsEntity(MemberDetailsEntity memberDetailsEntity);

    List<ClaimEntity> findAllByRequestDateBetween(LocalDate startDate, LocalDate endDate);

    ClaimEntity findByClaimRequestNo(Integer claimRequestNo);

}
