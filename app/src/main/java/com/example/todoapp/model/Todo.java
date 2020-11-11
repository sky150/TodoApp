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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
