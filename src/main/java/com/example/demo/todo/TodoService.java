package com.example.demo.todo;

import com.example.demo.ReturnJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TodoService {

    String getTodoList();

    String insertTodo(Map<String,Object> requestData, HttpServletRequest request, HttpServletResponse response);

    String deleteTodo(Map<String,Object> requestData, HttpServletRequest request, HttpServletResponse response);
}