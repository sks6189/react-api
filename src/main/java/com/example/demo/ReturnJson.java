package com.example.demo;

import com.example.demo.todo.Todo;

public class ReturnJson {
    private String code, description;
    private boolean msg;
    private Object data, param;

    public ReturnJson(){
        this.code = "9999";
        this.msg = false;
        this.description = "Error.";
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Object getParam() {
        return param;
    }
}
