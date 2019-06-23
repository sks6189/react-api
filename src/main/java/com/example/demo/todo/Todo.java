package com.example.demo.todo;


import java.util.Map;

public class Todo {

    private int parent, use, idx;
    private String title;

    public String getTitle() {
        return title;
    }

    public int getUse() {
        return use;
    }

    public int getParent() {
        return parent;
    }

    public int getIdx() {
        return idx;
    }

    public void setUse(int use) {
        this.use = use;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Todo(Map<String,Object> requestData){
        this.parent = (requestData.get("parent") == null) ? 0 : Integer.parseInt(requestData.get("parent").toString());
        this.title = (requestData.get("title") == null) ? "" : requestData.get("title").toString();
        if(requestData.get("use").toString() == "false"){
            this.use = 0;
        }else{
            this.use = 1;
        }
        this.idx = (requestData.get("idx") == null) ? 0 : Integer.parseInt(requestData.get("idx").toString());
    }
}
