package org.niteen.tasktracker.service.task;

import jakarta.validation.constraints.Email;
import org.niteen.tasktracker.dto.task.AssignTaskRequest;
import org.niteen.tasktracker.dto.task.CreateTaskRequest;
import org.niteen.tasktracker.dto.task.TaskDTO;
import org.niteen.tasktracker.dto.task.UpdateTaskRequest;
import org.niteen.tasktracker.entity.Task;
import org.niteen.tasktracker.entity.Team;
import org.niteen.tasktracker.entity.User;
import org.niteen.tasktracker.exception.TaskNotFoundException;
import org.niteen.tasktracker.exception.TeamNotFoundException;
import org.niteen.tasktracker.exception.UserNotFoundException;
import org.niteen.tasktracker.exception.ValidationFailedException;
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

        User assignedUser = userRepository.findById(request.getAssignedUserId())
                .orElseThrow(() ->
                        new UserNotFoundException("Assigned user not found"));

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() ->
                        new TeamNotFoundException("Team not found"));

        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getDueDate(),
                request.getStatus(),
                request.getPriority(),
                assignedUser,
                team
        );

        Task savedTask = taskRepository.save(task);

        return taskMapper.toDto(savedTask);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new TeamNotFoundException("Task with id "+ id + " not found"));

        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        if(tasks.isEmpty()) {
            throw new TaskNotFoundException("No tasks found");
        }

        return tasks.stream()
                .map(taskMapper :: toDto)
                .toList();
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new TaskNotFoundException("Task with id "+ id + " not found"));

        User assingedUser = userRepository.findById(request.getAssignedUserId()).orElseThrow(()->
                new  UserNotFoundException("Assigned user not found"));

        Team team = teamRepository.findById(request.getTeamId()).orElseThrow(()->
                new  TeamNotFoundException("Team not found"));


        task.setTeam(team);
        task.setAssignedUser(assingedUser);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());

        Task updatedTask = taskRepository.save(task);

        return taskMapper.toDto(updatedTask);
    }

    @Override
    public TaskDTO assignTask(Long id, AssignTaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new TaskNotFoundException("Task with id "+ id + " not found"));
        User assignedUser = userRepository.findById(request.getAssignedUserId()).orElseThrow(()->
                new  UserNotFoundException("Assigned user not found"));
        if (task.getAssignedUser().getId().equals(assignedUser.getId())) {
            throw new ValidationFailedException("Task is already assigned to this user.");
        }


         task.setAssignedUser(assignedUser);

        Task savedTask = taskRepository.save(task);

        return taskMapper.toDto(savedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new TaskNotFoundException("Task with id "+ id + " not found"));

        taskRepository.delete(task);

    }
}