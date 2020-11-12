package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todoapp.model.Todo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TodosMain extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_main);

        listView=(ListView)findViewById(R.id.todoList);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.all:
                        Intent intent1 = new Intent(TodosMain.this, TodosMain.class);
                        startActivity(intent1);
                        Toast.makeText(TodosMain.this, "All", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.in_progress:
                        Intent intent2 = new Intent(TodosMain.this, In_Progress.class);
                        startActivity(intent2);
                        Toast.makeText(TodosMain.this, "In Progress", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.done:
                        Intent intent3 = new Intent(TodosMain.this, Done.class);
                        startActivity(intent3);
                        Toast.makeText(TodosMain.this, "Done", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        //todoListView = (ListView) findViewById(R.id.tod)
        //showBooksInList();
    }

    private ListView todoListView;

    public void addButtonClicked(){
        Intent intent = new Intent(this, AddTodo.class);
        startActivity(intent);
    }

    public void addButtonClicked(View view) {
        Intent intent = new Intent(this, AddTodo.class);
        startActivity(intent);
    }
}