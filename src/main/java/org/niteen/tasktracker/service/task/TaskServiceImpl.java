package org.niteen.tasktracker.service.task;

import org.niteen.tasktracker.dto.task.AssignTaskRequest;
import org.niteen.tasktracker.dto.task.CreateTaskRequest;
import org.niteen.tasktracker.dto.task.TaskDTO;
import org.niteen.tasktracker.dto.task.UpdateTaskRequest;
import org.niteen.tasktracker.mapper.TaskMapper;
import org.niteen.tasktracker.repository.TaskRepository;
import org.niteen.tasktracker.repository.TeamRepository;
import org.niteen.tasktracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            UserRepository userRepository,
            TeamRepository teamRepository,
            TaskMapper taskMapper) {

        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO createTask(CreateTaskRequest request) {
        return null;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return List.of();
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskRequest request) {
        return null;
    }

    @Override
    public TaskDTO assignTask(Long id, AssignTaskRequest request) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}