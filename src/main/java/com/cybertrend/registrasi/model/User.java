package com.cybertrend.registrasi.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = false, length = 255)
    private String nama;

    @Column(nullable = false, unique = false, length = 13)
    private String telp;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, unique = false, length = 255)
    private String password;
    
}
