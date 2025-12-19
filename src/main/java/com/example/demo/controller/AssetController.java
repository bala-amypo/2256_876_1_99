package com.example.demo.AssetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@RestController
@RequestMapping("/api/assets")
public class AssetController{

    @Autowired
    AssetService assetservice;

    @PostMapping("/{vendorld}/{ruleld}")
    public ResponseEntity<Asset> createAsset(@PathVariable Long vendorId,@PathVariable Long ruleId,@RequsetBody Asset asset ){
        Asset savedasset= assetservice.createAsset(vendorId,ruleId,asset);
        return new ResponseEntity<>(savedasset,HttpStatus.CREATED);
    }

    // @GetMapping()

    // @GetMapping("/status/{status}")

    // @GetMapping("/{id}")

}


