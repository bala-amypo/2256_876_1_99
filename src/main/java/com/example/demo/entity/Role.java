package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) 
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>(); 


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }


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
