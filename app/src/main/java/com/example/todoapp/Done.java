package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Done extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.all:
                        Intent intent1 = new Intent(Done.this, TodosMain.class);
                        startActivity(intent1);
                        Toast.makeText(Done.this, "All", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.in_progress:
                        Intent intent2 = new Intent(Done.this, In_Progress.class);
                        startActivity(intent2);
                        Toast.makeText(Done.this, "In Progress", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.done:
                        Intent intent3 = new Intent(Done.this, Done.class);
                        startActivity(intent3);
                        Toast.makeText(Done.this, "Done", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
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