package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.AssetLifecycleEvent;

public interface AssetLifecycleEventService{
    public AssetLifecycleEvent logEvent(Long assetId,AssetLifecycleEvent event);
    public List<AssetLifecycleEvent> getEventsForAsset(Long assetId);
}