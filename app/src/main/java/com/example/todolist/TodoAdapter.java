package com.example.todolist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<TodoModel>todoList;
    private MainActivity activity;


    public TodoAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return  new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    public int getItemCount(){
        return todoList.size();
    }

    private boolean toBoolean(int n) {
        return n!=0;
    }

    public  void  setTasks(List<TodoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }
    public Context getContent(){
        return activity;
    }
    public void deleteItem(int position){
        TodoModel item = todoList.get(position);
    }
    public void editItem(int position){
        TodoModel item = todoList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("text",item.getId());
        bundle.putString("task",item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(activity.getSupportFragmentManager(), AddNewTask.TAG);
    }
    public static class  ViewHolder extends  RecyclerView.ViewHolder {
        CheckBox task;

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}