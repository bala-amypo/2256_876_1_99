package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{
    List<Vendor>findByVendorName(String vendorName);
}