package com.example.demo1.services;

import com.example.demo1.entities.Task;
import com.example.demo1.entities.TaskList;
import com.example.demo1.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    // Aqui se define la logica del negocio
   private TaskRepository repository;


    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public List<Task> getTaskList(){
        return this.repository.findAll();
    }

    public Task createTask(Task task){
        return this.repository.save(task);
    }

    public boolean markTaskDone(Long id){
        Optional<Task> task = this.repository.findById(id);
        if(task.isPresent()){
            task.get().setDone(true);
            this.repository.save(task.get());
            return true;
        }
        return false;
    }

    public boolean deleteTask(Long id){
        this.repository.deleteById(id);
        return true;
    }
}
