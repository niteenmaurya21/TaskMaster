package org.niteen.tasktracker.dto.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateTeamRequest {
    @NotBlank(message = "Team name is required")
    @Size(max = 100, message = "Team name cannot exceed 100 characters")
    private String teamName;

    @NotBlank(message = "Team description is required")
    @Size(max = 500, message = "Team description cannot exceed 500 characters")
    private String teamDescription;

    @NotNull(message = "Leader is required")
    private Long leaderId;

    public UpdateTeamRequest(String teamName, String teamDescription, Long leaderId) {
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.leaderId = leaderId;
    }

    public UpdateTeamRequest() {

    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
