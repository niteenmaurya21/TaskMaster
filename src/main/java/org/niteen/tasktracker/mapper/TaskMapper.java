package org.niteen.tasktracker.mapper;

import org.niteen.tasktracker.dto.task.CreateTaskRequest;
import org.niteen.tasktracker.dto.task.TaskDTO;
import org.niteen.tasktracker.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO toDto(Task task) {

        if (task == null) {
            return null;
        }

        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());

        if (task.getAssignedUser() != null) {
            dto.setAssignedUserId(task.getAssignedUser().getId());
            dto.setAssignedUserName(task.getAssignedUser().getName());
        }

        if (task.getTeam() != null) {
            dto.setTeamId(task.getTeam().getId());
            dto.setTeamName(task.getTeam().getTeamName());
        }

        return dto;
    }

    public Task toEntity(CreateTaskRequest request) {

        if (request == null) {
            return null;
        }

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setPriority(request.getPriority());

        // assignedUser and team will be set in the Service layer
        // after fetching them from their repositories.

        return task;
    }
}