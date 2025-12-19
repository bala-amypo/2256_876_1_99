package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.example.demo.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long>{
    boolean existsByAssetTag(String assetTag );
    List<Asset> findByStatus(String status);
    List<Vendor> findByVendor(Vendor vendor);
}