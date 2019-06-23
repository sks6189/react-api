package com.example.demo.todo;

import com.example.demo.ReturnJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * return 정리 ( code : description(msg) )
 *  0000 : 정상적으로 입력되었습니다. (true)
 *
 * */

@Service
public class TodoServiceImplement implements TodoService, Serializable {
    private TodoMapper todoMapper;
    private String returnString;

    @Autowired
    TodoServiceImplement(TodoMapper todoMapper){
        this.todoMapper = todoMapper;
    }

    public String getTodoList(){
        ReturnJson returnJson = new ReturnJson();

        returnJson.setCode("0000");
        returnJson.setMsg(true);
        returnJson.setDescription("Success Load List.");

        returnJson.setData(todoMapper.getTodoList().toArray());

        return returnJsonToString(returnJson);
    }

    @Override
    public String insertTodo(Map<String,Object> requestData, HttpServletRequest request, HttpServletResponse response) {
        ReturnJson returnJson = new ReturnJson();

        Todo todo = new Todo(requestData);

        System.out.println(todo.getUse());

        if(todo.getIdx() == 0 && todoMapper.insertTodo(todo) > 0) {
            returnJson.setCode("0000");
            returnJson.setMsg(true);
            returnJson.setDescription("정상적으로 입력되었습니다.");
            returnJson.setParam((Object) todo);
        }else if(todo.getIdx() > 0 && todoMapper.updateTodo(todo) > 0){
            returnJson.setCode("0000");
            returnJson.setMsg(true);
            returnJson.setDescription("정상적으로 수정되었습니다.");
            returnJson.setParam((Object) todo);
        }else{
            returnJson.setCode("0199");
            returnJson.setMsg(false);
            returnJson.setDescription("새로고침 후 다시 시도해주세요.");
        }

        return returnJsonToString(returnJson);
    }

    @Override
    public String deleteTodo(Map<String,Object> requestData, HttpServletRequest request, HttpServletResponse response) {
        ReturnJson returnJson = new ReturnJson();

        Todo todo = new Todo(requestData);

        Integer parentCount = todoMapper.getParentTodoCount(todo.getIdx());
        System.out.println(parentCount);

        if( parentCount > 0 ){
            returnJson.setCode("0298");
            returnJson.setMsg(false);
            returnJson.setDescription("해당 댓글이 달려있어 삭제할 수 없습니다.");
        }else{
            if(todoMapper.deleteTodo(todo) > 0) {
                returnJson.setCode("0000");
                returnJson.setMsg(true);
                returnJson.setDescription("정상적으로 삭제하였습니다.");
                returnJson.setParam((Object) todo);
            }else{
                returnJson.setCode("0299");
                returnJson.setMsg(false);
                returnJson.setDescription("새로고침 후 다시 시도해주세요.");
            }
        }

        return returnJsonToString(returnJson);
    }


    private String returnJsonToString(ReturnJson returnJson){
        String returnString = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            returnString = objectMapper.writeValueAsString(returnJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnString;
    }

    private Todo hashMapToTodo(HashMap<String, Object> requestParam){

        ObjectMapper objectMapper = new ObjectMapper();
        Todo todo = objectMapper.convertValue(requestParam, Todo.class);

        return todo;
    }
}
