package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import org.hibernate.mapping.ManyToOne;
import org.hibernate.mapping.OneToOne;

@Entity
public class AssetDisposal{
    @Id
    private Long id;
    private OneToOne asset;
    private String disposalMethod;
    private double disposalValue;
    private LocalDate disposalDate;
    private ManyToOne approveBy;
    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OneToOne getAsset() {
        return asset;
    }
    public void setAsset(OneToOne asset) {
        this.asset = asset;
    }
    public String getDisposalMethod() {
        return disposalMethod;
    }
    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }
    public double getDisposalValue() {
        return disposalValue;
    }
    public void setDisposalValue(double disposalValue) {
        this.disposalValue = disposalValue;
    }
    public LocalDate getDisposalDate() {
        return disposalDate;
    }
    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
    }
    public ManyToOne getApproveBy() {
        return approveBy;
    }
    public void setApproveBy(ManyToOne approveBy) {
        this.approveBy = approveBy;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public AssetDisposal(Long id, OneToOne asset, String disposalMethod, double disposalValue, LocalDate disposalDate,
            ManyToOne approveBy, LocalDateTime createdAt) {
        this.id = id;
        this.asset = asset;
        this.disposalMethod = disposalMethod;
        this.disposalValue = disposalValue;
        this.disposalDate = disposalDate;
        this.approveBy = approveBy;
        this.createdAt = createdAt;
    }
    public AssetDisposal() {
    }
}