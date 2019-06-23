package com.example.demo.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TodoApplication {

    @RequestMapping("/")
    public String Index(){
        return "hello min";
    }



}

