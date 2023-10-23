package com.cleanarch.application.controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTodoResponse {
    public Integer id;
    public String action;
    public Boolean done;
}
