package com.example.jswithspring.entity.hybrid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HybridOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String name;

    @Getter
    @Column(nullable = false)
    private Integer cost;

    public HybridOrder(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }
}