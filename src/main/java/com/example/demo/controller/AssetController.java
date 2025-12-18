package com.example.demo.AssetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RestMapping("/")
public class AssetController{

    @Autowired
    AssetService ser;

    @PostMapping("/")
    public Asset createAsset(Long vendorld,Long ruleld,Asset asset){
        
    }
}


