package org.niteen.tasktracker.dto.task;

import jakarta.validation.constraints.NotNull;

public class AssignTaskRequest {
    @NotNull(message = "AssignedUserId is required")
    private Long AssignedUserId;

    public AssignTaskRequest(Long AssignedUserId) {
        this.AssignedUserId = AssignedUserId;
    }
    public AssignTaskRequest() {

    }

    public void setAssignedUserId(Long assignedUserId) {
        this.AssignedUserId = assignedUserId;
    }

    public Long getAssignedUserId() {
        return AssignedUserId;
    }

}
