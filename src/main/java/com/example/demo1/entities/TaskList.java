package com.example.demo1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private String name;
    private List<Task> tasks;

    public TaskList(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void removeTask(String description){
        this.tasks = tasks.stream().filter(t->{
            return !t.getDescription().equals(description);
        }).collect(Collectors.toList());
    }

    public void printTasks(){
        System.out.println("----------- Tasks List------------");
        this.tasks.forEach(task -> {
            System.out.println("----------- Task ------------");
            System.out.println("Descripción: "+task.getDescription());
            System.out.println("Fecha: "+task.getDueDate());
            System.out.println("Realizada: "+ (task.isDone()?"yes":"no"));
            System.out.println("-------------------------------");
        });
        System.out.println("-------------- END --------------");
    }
}
