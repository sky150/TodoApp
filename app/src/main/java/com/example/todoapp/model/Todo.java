package com.example.todoapp.model;

import com.orm.SugarRecord;

public class Todo extends SugarRecord {
    String title;
    String text;
    int done;

    public Todo(){

    }

    public Todo(String title, String text, int done) {
        this.title = title;
        this.text = text;
        this.done = done;
    }
}
