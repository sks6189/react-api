package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* CORS(Cross-origin resource sharing)이란, 웹 페이지의 제한된 자원을 외부 도메인에서 접근을 허용해주는 메커니즘입니다 */
@CrossOrigin(origins = "*")
@Controller
public class TodoController {
    private TodoService todoService;

    /*
    * 오토와이어링은 스프링이 빈의 요구 사항과 매칭 되는 애플리케이션 컨텍스트상에서 다른 빈을 찾아
    * 빈 간의 의존성을 자동으로 만족시키도록 하는 수단이다
    * */

    @Autowired
    TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @RequestMapping("/todo")
    @ResponseBody
    public List<Map<String,Object>> getTodoList(){
        return todoService.getTodoList();
    }
}

