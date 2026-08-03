package org.niteen.tasktracker.dto.team;

import jakarta.validation.constraints.NotNull;

public class AddMemberRequest {
    @NotNull(message = "User ID is required")
    private Long userId;

    public AddMemberRequest(Long userId) {
        this.userId = userId;
    }

    public AddMemberRequest() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
