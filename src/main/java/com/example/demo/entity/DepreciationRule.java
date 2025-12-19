package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "depreciation_rules")
public class DepreciationRule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String method;

    private Integer usefulLifeYears;

    private Double salvageValue;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "depreciationRule")
    private Set<Asset> assets;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public int getUsefulLifeYears() {
        return usefulLifeYears;
    }
    public void setUsefulLifeYears(int usefulLifeYears) {
        this.usefulLifeYears = usefulLifeYears;
    }
    public double getSalvageValue() {
        return salvageValue;
    }
    public void setSalvageValue(double salvageValue) {
        this.salvageValue = salvageValue;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public DepreciationRule(Long id, String ruleName, String method, int usefulLifeYears, double salvageValue,LocalDateTime createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        this.method = method;
        this.usefulLifeYears = usefulLifeYears;
        this.salvageValue = salvageValue;
        this.createdAt = createdAt;
    }
    public DepreciationRule() {
    }
}