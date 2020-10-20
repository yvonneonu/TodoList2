package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView tasksRecyclerView;
    private TodoAdapter tasksadapter;
    private List<TodoModel> tasksList;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        tasksList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksadapter = new TodoAdapter(this);
        tasksRecyclerView.setAdapter(tasksadapter);

        fab = findViewById(R.id.fab);

        Collections.reverse(tasksList);
        tasksadapter.setTasks(tasksList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddNewTask().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });


    }
}



