package com.example.projectTest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Entity
@Table
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String name;

    @Getter
    @Column(nullable = false)
    private Integer birth;

    @Getter
    @Column(nullable = false)
    private String email;

    @Getter
    @Column(nullable = false)
    private String password;

    public Account(String name, Integer birth, String email, String password) {
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.password = password;
    }
}

