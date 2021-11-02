package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class TodoModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    //(name ="todoOrder") 로 콜럼이름을 작성해주었다다
    @Column(name = "tododOrder", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}
