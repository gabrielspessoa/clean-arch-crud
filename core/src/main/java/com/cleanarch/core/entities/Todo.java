package com.cleanarch.core.entities;

import lombok.Data;

@Data
public class Todo {
    private Integer id;
    private String action;
    private Boolean done;

    public Todo(String action, Boolean done) {
        this.action = action;
        this.done = done;
    }

    public Todo(Integer id, String action, Boolean done) {
        this.id = id;
        this.action = action;
        this.done = done;
    }
}
