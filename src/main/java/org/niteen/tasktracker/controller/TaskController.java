package org.niteen.tasktracker.controller;


import jakarta.validation.Valid;
import org.niteen.tasktracker.dto.task.AssignTaskRequest;
import org.niteen.tasktracker.dto.task.CreateTaskRequest;
import org.niteen.tasktracker.dto.task.TaskDTO;
import org.niteen.tasktracker.dto.task.UpdateTaskRequest;
import org.niteen.tasktracker.service.task.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody CreateTaskRequest request) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/assign")
    public ResponseEntity<TaskDTO> assignTask(@PathVariable Long id, @Valid @RequestBody AssignTaskRequest request) {

        return ResponseEntity.ok(taskService.assignTask(id, request));
    }
}