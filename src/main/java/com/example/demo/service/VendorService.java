package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.Vendor;

public interface VendorService{
    public Vendor createVendor(Vendor vendor);
    public List<Vendor> getAllVendors();
}