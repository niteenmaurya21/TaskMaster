package org.niteen.tasktracker.dto.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.niteen.tasktracker.enums.Priority;
import org.niteen.tasktracker.enums.TaskStatus;

import java.time.LocalDateTime;


    public class UpdateTaskRequest {

        @NotBlank(message = "Title is required")
        private String title;

        @NotBlank(message = "Description is required")
        @Size(max = 1000, message = "Description cannot exceed 1000 characters")
        private String description;

        @NotNull(message = "Due date is required")
        @Future(message = "Due date must be in the future")
        private LocalDateTime dueDate;

        @NotNull(message = "Priority is required")
        private Priority priority;

        @NotNull(message = "Task status is required")
        private TaskStatus status;

        @NotNull(message = "Assigned user is required")
        private Long assignedUserId;

        @NotNull(message = "Team Id is required")
        private Long teamId;

        public UpdateTaskRequest(String title,
                                 String description,
                                 LocalDateTime dueDate,
                                 Priority priority,
                                 TaskStatus status,
                                 Long assignedUserId,
                                 Long teamId) {
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.priority = priority;
            this.status = status;
            this.assignedUserId = assignedUserId;
            this.teamId = teamId;
        }

        public UpdateTaskRequest() {

        }

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

        public TaskStatus getStatus() {
            return status;
        }

        public void setStatus(TaskStatus status) {
            this.status = status;
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

