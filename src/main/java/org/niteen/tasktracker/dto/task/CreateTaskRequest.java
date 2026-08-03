package org.niteen.tasktracker.dto.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.niteen.tasktracker.enums.Priority;


import java.time.LocalDateTime;

public class CreateTaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "description cannot be empty")
    @Size(max = 1000, message = "cannot exceed more than 1000 characters")
    private String description;

    @NotNull(message = "duedate is required")
    @Future(message = "duedate must be in future")
    private LocalDateTime dueDate;

    @NotNull(message = "priority is required")
    private Priority priority;

    @NotNull(message = "assigned user is required")
    private Long assignedUserId;

    @NotNull(message = "team is required")
    private Long teamId;

    public CreateTaskRequest(String title,
                             String description,
                             LocalDateTime dueDate,
                             Priority priority,
                             Long assignedUserId,
                             Long teamId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignedUserId = assignedUserId;
        this.teamId = teamId;
    }

    public CreateTaskRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}