package com.example.demo.AssetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@RestController
@RestMapping("/api/assets")
public class AssetController{

    @Autowired
    AssetService ser;

    @PostMapping("/{vendorld}/{ruleld}")
    public Asset createAsset(Asset ass){
        return ser.
    }

    @GetMapping("/assetlist")

    @GetMapping("/status/{status}")

    @GetMapping("/{id}")

}


