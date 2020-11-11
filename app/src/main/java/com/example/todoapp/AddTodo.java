package com.example.todoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapp.model.Todo;
import com.orm.SugarContext;

import java.util.List;

public class AddTodo extends AppCompatActivity {

    private Button buttonSave = null;
    private Button buttonPhoto = null;

    private TextView titleText = null;
    private TextView textText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        SugarContext.init(this);

        buttonSave = (Button) findViewById(R.id.add_todo_save_btn);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonSaveClick");
                doButtonSaveClick();
            }
        });

        titleText = (EditText) findViewById(R.id.add_todo_title);
        textText = (EditText) findViewById(R.id.add_todo_description);

    }
    private void doButtonSaveClick() {
        Todo todo = new Todo(titleText.getText().toString(),textText.getText().toString(), 0);
        todo.save();
        List<Todo> todos = Todo.listAll(Todo.class);
        System.out.println("COUNT: " + todos.size());

    }

    private void doButtonResetClick() {
        titleText.setText("");
        textText.setText("");
    }

    public void onTerminate() {
        SugarContext.terminate();
    }
}