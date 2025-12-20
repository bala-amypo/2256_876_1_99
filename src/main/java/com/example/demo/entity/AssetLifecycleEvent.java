package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
// import org.hibernate.mapping.ManyToOne;
// import org.hibernate.mapping.OneToOne;

@Entity
@Table(name = "asset_lifecycle_events")
public class AssetLifecycleEvent{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String eventType;

    private String eventDescription;

    private LocalDate eventDate;

    private LocalDateTime loggedAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ManyToOne getAsset() {
        return asset;
    }
    public void setAsset(ManyToOne asset) {
        this.asset = asset;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getEventDiscription() {
        return eventDiscription;
    }
    public void setEventDiscription(String eventDiscription) {
        this.eventDiscription = eventDiscription;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
    public AssetLifecycleEvent(Long id, ManyToOne asset, String eventType, String eventDiscription, LocalDate eventDate,
            LocalDateTime loggedAt) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.eventDiscription = eventDiscription;
        this.eventDate = eventDate;
        this.loggedAt = loggedAt;
    }
    public AssetLifecycleEvent() {
    }
}