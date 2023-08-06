package com.example.dictionary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {

    @Id
    @Column(name = "role_id")
    private int id;
    @Column(name = "role_name")
    private String name;

    public Role(int id) {
        this.id = id;
    }

    public Role() {
    }
}
