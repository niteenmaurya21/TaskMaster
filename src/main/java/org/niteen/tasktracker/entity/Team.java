package org.niteen.tasktracker.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    //don't need @Column on id cuz it is a primaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size( max = 100, message = "team message cannot exceed 100 characters")
    @Column(unique = true,  nullable = false)
    private String teamName;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false)
    private String teamDescription;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false)
    private User leader;

    @ManyToMany
    @JoinTable(name = "team_members",
    joinColumns = @JoinColumn(name = "team_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> members = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<Task> tasks = new ArrayList<>();

    public Team(
                String teamName,
                String teamDescription,
                User leader)
                {

        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.leader = leader;

    }
    public Team() {}

    public Long getId() {
        return id;
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

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public List<User> getMembers() {
        return members;
    }



    public List<Task> getTasks() {
        return tasks;
    }


}
