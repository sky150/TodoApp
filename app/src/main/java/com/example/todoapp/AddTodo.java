package com.example.todoapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapp.model.Todo;
import com.orm.SugarContext;

import java.util.List;

public class AddTodo extends AppCompatActivity {

    private Button buttonSave = null;
    private Button buttonPhoto = null;
    private Button buttonReset = null;

    private TextView titleText = null;
    private TextView textText = null;

    private ImageView imgCapture;
    private static final int Image_Capture_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        SugarContext.init(this);

        buttonSave = (Button) findViewById(R.id.add_todo_reset_btn);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonSaveClick");
                doButtonSaveClick();
            }
        });

        buttonReset = (Button) findViewById(R.id.add_todo_reset_btn);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonResetClick");
                doButtonResetClick();
            }
        });

        titleText = (EditText) findViewById(R.id.add_todo_title);
        textText = (EditText) findViewById(R.id.add_todo_description);

        //Camera
        buttonPhoto =(Button)findViewById(R.id.add_todo_cam_btn);
        imgCapture = (ImageView) findViewById(R.id.add_todo_imageview);
        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);
            }
        });

    }
    private void doButtonSaveClick() {
        Todo todo = new Todo(titleText.getText().toString(),textText.getText().toString(), 0);
        todo.save();
        List<Todo> todos = Todo.listAll(Todo.class);
        System.out.println("COUNT: " + todos.size());
        for(int i = 0; i < todos.size(); i++){
            System.out.println(todos.get(i).getTitle());
            System.out.println(todos.get(i).getText());
            System.out.println(todos.get(i).getDone());
        }
        buttonListClicked();

    }

    private void buttonListClicked() {
        Intent intent = new Intent(this, TodosMain.class);
        String message = "Come from Add!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private void doButtonResetClick() {
        titleText.setText("");
        textText.setText("");
        imgCapture.setImageResource(android.R.color.transparent);
        imgCapture.getLayoutParams().height = 660;
    }

    public void onTerminate() {
        SugarContext.terminate();
    }

    //Camera
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imgCapture.setImageBitmap(bp);
                imgCapture.getLayoutParams().height = 1700;
                //MediaStore.Images.Media.insertImage(getContentResolver(), bp, "Aus App" , "Im Emu geschossen");
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
}