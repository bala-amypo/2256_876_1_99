package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.demo.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{
    Optional<Vendor> findByVendorName(String vendorName);
}