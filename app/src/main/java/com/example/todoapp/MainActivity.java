package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {    @Override
protected void onCreate(Bundle savedInstanceState) {
    Intent intent;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.all:
                    Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent1);
                    Toast.makeText(MainActivity.this, "All", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.in_progress:
                    Intent intent2 = new Intent(MainActivity.this, In_Progress.class);
                    startActivity(intent2);
                    Toast.makeText(MainActivity.this, "In Progress", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.done:
                    Intent intent3 = new Intent(MainActivity.this, Done.class);
                    startActivity(intent3);
                    Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    break;                }
            return true;
        }
    });
}
}