package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.mapping.ManyToOne;
import java.time.LocalDate;

@Entity
public class Asset{
    @Id
    private Long id;
    private String assetTag;
    private String assetName;
    private ManyToOne vendor;
    private LocalDate purchaseDate;
    private double purchaseCost;
    private ManyToOne depreciationRule;
    private String status;
    private LocalDateTime createAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAssetTag() {
        return assetTag;
    }
    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    public ManyToOne getVendor() {
        return vendor;
    }
    public void setVendor(ManyToOne vendor) {
        this.vendor = vendor;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public double getPurchaseCost() {
        return purchaseCost;
    }
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
    public ManyToOne getDepreciationRule() {
        return depreciationRule;
    }
    public void setDepreciationRule(ManyToOne depreciationRule) {
        this.depreciationRule = depreciationRule;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public Student(Long id, String assetTag, String assetName, ManyToOne vendor, LocalDate purchaseDate,
            double purchaseCost, ManyToOne depreciationRule, String status, LocalDateTime createAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetName = assetName;
        this.vendor = vendor;
        this.purchaseDate = purchaseDate;
        this.purchaseCost = purchaseCost;
        this.depreciationRule = depreciationRule;
        this.status = status;
        this.createAt = createAt;
    }
    public Student() {
    }
}