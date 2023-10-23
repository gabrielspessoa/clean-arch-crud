package com.cleanarch.application.controller;

import lombok.Getter;

@Getter
public class CreateTodoRequest {
    public String action;
    public Boolean done;
}
