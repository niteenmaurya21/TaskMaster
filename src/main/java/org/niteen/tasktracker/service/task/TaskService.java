package org.niteen.tasktracker.service.task;

import org.niteen.tasktracker.dto.task.AssignTaskRequest;
import org.niteen.tasktracker.dto.task.CreateTaskRequest;
import org.niteen.tasktracker.dto.task.TaskDTO;
import org.niteen.tasktracker.dto.task.UpdateTaskRequest;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(CreateTaskRequest request);

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(Long id, UpdateTaskRequest request);

    TaskDTO assignTask(Long id, AssignTaskRequest request);

    void deleteTask(Long id);
}
