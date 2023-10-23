package com.cleanarch.application.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo")
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String action;
    private Boolean done;

    public TodoEntity(String action, Boolean done) {
        this.action = action;
        this.done = done;
    }
}
