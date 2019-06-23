package com.example.demo.todo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Repository
@Mapper
public interface TodoMapper {

    List<Map<String, Object>> getTodoList();

    int getParentTodoCount(int parent);

    int insertTodo(Todo todo);

    int updateTodo(Todo todo);

    int deleteTodo(Todo todo);
}

