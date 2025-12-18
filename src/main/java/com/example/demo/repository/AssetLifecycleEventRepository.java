package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssetLifecycleEvent;

@Repository
public interface AssetLifecycleEventRepository extends JpaRepository<AssetLifecycleEvent,Long>{
    List<AssetLifecycleEvent> findByAssetIdOrderByEventDateDesc(Long assetId);
}