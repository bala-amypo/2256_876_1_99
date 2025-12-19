package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.mapping.ManyToOne;
import java.time.LocalDate;

@Entity
public class Asset{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String assetTag;

    private String assetName;

    @ManyToOne
    private Vendor vendor;

    private LocalDate purchaseDate;

    private Double purchaseCost;

    @ManyToOne
    private DepreciationRule depreciationRule;

    // ACTIVE / MAINTENANCE / DISPOSED
    private String status;

    private LocalDateTime createdAt;

    // Asset → Lifecycle Events (One-to-Many)
    @OneToMany(mappedBy = "asset")
    private Set<AssetLifecycleEvent> lifecycleEvents;

    // Asset → Disposal (One-to-One)
    @OneToOne(mappedBy = "asset")
    private AssetDisposal disposal;
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Asset(Long id, String assetTag, String assetName, ManyToOne vendor, LocalDate purchaseDate,
            double purchaseCost, ManyToOne depreciationRule, String status, LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.assetName = assetName;
        this.vendor = vendor;
        this.purchaseDate = purchaseDate;
        this.purchaseCost = purchaseCost;
        this.depreciationRule = depreciationRule;
        this.status = status;
        this.createdAt = createdAt;
    }
    public Asset() {
    }
}