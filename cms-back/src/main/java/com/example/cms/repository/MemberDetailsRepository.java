package com.example.cms.repository;

import com.example.cms.entity.MemberDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDetailsRepository extends JpaRepository<MemberDetailsEntity, String> {
    MemberDetailsEntity findByMemberId(String memberId);
    List<MemberDetailsEntity> findByFirstName(String firstName);
}