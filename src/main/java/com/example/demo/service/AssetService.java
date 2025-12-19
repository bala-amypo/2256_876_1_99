package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.Asset;

public interface AssetService{
    public Asset createAsset(Long vendorId,Long ruleId,Asset asset);
    public List<Asset> getAssetsByStatus(String status);
    public List<Asset> getAllAssets();
    public Asset getAsset(Long id);
}