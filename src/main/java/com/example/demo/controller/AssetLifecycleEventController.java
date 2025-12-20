package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {

    private final AssetLifecycleEventService eventService;

    public AssetLifecycleEventController(AssetLifecycleEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/{assetId}")
    public AssetLifecycleEvent addEvent(@PathVariable Long assetId,@RequestBody AssetLifecycleEvent event) {
        return eventService.addEvent(assetId, event);
    }

    @GetMapping("/asset/{assetId}")
    public List<AssetLifecycleEvent> getEvents(@PathVariable Long assetId) {
        return eventService.getEventsByAsset(assetId);
    }
}
