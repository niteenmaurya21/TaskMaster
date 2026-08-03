package org.niteen.tasktracker.dto.team;

import jakarta.validation.constraints.NotNull;

public class AddMemberRequest {
    @NotNull(message = "User ID is required")
    private Long userId;
}
