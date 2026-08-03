package org.niteen.tasktracker.dto.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class TeamDTO {

    //Task,Team,Comment,Attachment and user Dto does not require Validators
    // they are only used in Requests

    private Long id;

    private String teamName;

    private String teamDescription;

    private LocalDateTime createdAt;

    private Long leaderId;

    private String leaderName;

    private int memberCount;

    public TeamDTO(Long id,
                   String teamName,
                   String teamDescription,
                   LocalDateTime createdAt,
                   Long leaderId,
                   String leaderName,
                   int memberCount) {
        this.id = id;
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.createdAt = createdAt;
        this.leaderId = leaderId;
        this.leaderName = leaderName;
        this.memberCount = memberCount;
    }

    public TeamDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
