package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // ✅ REQUIRED FOR TESTS
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // ✅ name must exist
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>(); // ✅ avoid NPE

    // ===== Constructors =====

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    // ⚠️ Keep this ONLY if tests explicitly use it
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }
}
