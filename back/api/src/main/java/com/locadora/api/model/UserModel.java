package com.locadora.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data

public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

}
