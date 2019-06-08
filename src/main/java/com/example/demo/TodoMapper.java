package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface TodoMapper {
    List<Map<String, Object>> getTodoList();
}

