package com.example.demo1.controllers;

import com.example.demo1.entities.*;
import com.example.demo1.services.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FrontControllers {

    TaskService service;

    public FrontControllers(TaskService service){
        this.service = service;
    }


    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        // Nombre del archivo html a devolver
        return "index";
    }

    @GetMapping("/tasks")
    public String tasks(Model model) {
        List<Task> tasks = this.service.getTaskList();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String addTask(Model model ){
        model.addAttribute("task", new Task());

        return "newTask";
    }
}
