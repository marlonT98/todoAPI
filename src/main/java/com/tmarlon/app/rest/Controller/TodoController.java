package com.tmarlon.app.rest.Controller;

import com.tmarlon.app.rest.model.Task;
import com.tmarlon.app.rest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;


    @GetMapping("/")
    public String hola() {
        return "hola";
    }


    @GetMapping("/tasks")
    public List<Task> getTask() {
        return todoRepository.findAll();

    }

    @PostMapping("/savetasks")
    public String saveTask(@RequestBody Task task) {

        todoRepository.save(task);
        return "saved Task";
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {

        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save(updateTask);
        return "updated task";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {

        Task task = todoRepository.findById(id).get();
        todoRepository.delete(task);
        return "delete task";

    }


}
