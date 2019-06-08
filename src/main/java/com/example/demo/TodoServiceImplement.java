package com.example.demo;

import com.example.demo.TodoService;
import com.example.demo.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodoServiceImplement implements TodoService{
    private TodoMapper todoMapper;

    @Autowired
    TodoServiceImplement(TodoMapper todoMapper){
        this.todoMapper = todoMapper;
    }

    public List<Map<String,Object>> getTodoList(){
        return todoMapper.getTodoList();
    }

}
