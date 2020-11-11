package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TodosMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_main);
    }

    public void addButtonClicked(){
        Intent intent = new Intent(this, AddTodo.class);
        startActivity(intent);
    }

    public void addButtonClicked(View view) {
        Intent intent = new Intent(this, AddTodo.class);
        startActivity(intent);
    }
}