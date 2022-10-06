package com.example.demo1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {
    // Creacion de los atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column(name = "description")
    private String description;
    @Column(name = "done")
    private boolean done;
    @Column(name = "dueDate")
    private LocalDate dueDate;

    // Constructor
    public Task(String description,boolean done,LocalDate dueDate) {
        this.setDescription(description);
        this.setDone(done);
        this.setDueDate(dueDate);
    }

    public Task(){

    }

    // Getters y setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description: '" + description + '\'' +
                ", done: " + (done?"Si":"no") +
                ", dueDate(AAAA-DD-MM): " + dueDate +
                '}';
    }
}
