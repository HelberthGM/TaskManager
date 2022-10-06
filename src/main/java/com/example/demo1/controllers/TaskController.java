package com.example.demo1.controllers;

import com.example.demo1.entities.Task;
import com.example.demo1.entities.TaskList;
import com.example.demo1.services.TaskService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskController {
    // Se comunica con la interfaz de usuario
    TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }
/*
    @GetMapping("/tasks")
    public List<Task> TaskList(){
        Task tarea1 = new Task("Comer 12 uvas",false, LocalDate.of(2022,12,31));
        //"Este es un recurso http para que se despliege en su navegador";
        return this.service.getTaskList();
    }

 */


    @PostMapping("/tasks")
    public RedirectView createTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Task task, Model model){
        model.addAttribute(task);
        task.setDone(false);
        this.service.createTask(task);
        return new RedirectView("/tasks");
    }

    @PatchMapping("/tasks/{id}")
    public RedirectView updateTask(@PathVariable("id")Long id){
        this.service.markTaskDone(id);
        return new RedirectView("/tasks");
    }

    @DeleteMapping("/tasks/{id}")
    public RedirectView deleteTask(@PathVariable("id")Long id){
        this.service.deleteTask(id);
        return new RedirectView("/tasks");
    }
    }
