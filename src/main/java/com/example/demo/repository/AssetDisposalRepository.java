package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssetDisposal;

@Repository
public interface AssetDisposalRepository extends JpaRepository<AssetDisposal,Long>{
    List<AssetDisposal> findByApprovedBy(User approvedBy);
}