    package org.niteen.tasktracker.entity;


    import jakarta.persistence.*;
    import jakarta.validation.constraints.Future;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;
    import org.niteen.tasktracker.enums.Priority;
    import org.niteen.tasktracker.enums.TaskStatus;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "tasks")
    public class Task {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(nullable = false)
        @NotBlank
        private String title;

        @NotBlank
        @Column(nullable = false)
        @Size(max = 1000)
        private String description;

        @CreationTimestamp
        @Column(nullable = false)
        private LocalDateTime createdAt;


        @Column(nullable = false)
        @Future(message = "date must be in the future")
        private LocalDateTime dueDate;

        @UpdateTimestamp
        @Column(nullable = false)
        private LocalDateTime updatedAt;

        @NotNull
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TaskStatus status;

        @NotNull
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Priority priority;

        @ManyToOne(fetch = FetchType.LAZY,optional = false)
        @JoinColumn(name = "assigned_user_id", nullable = false)
        private User assignedUser;

        @ManyToOne(fetch = FetchType.LAZY , optional = false)
        @JoinColumn(name = "team_id", nullable = false)
        private Team team;

        @OneToMany(mappedBy = "task",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        private List<Attachment> attachments =  new ArrayList<>();

        @OneToMany(mappedBy = "task",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        private List<Comment> comments = new ArrayList<>();


        public Task (){

        }

        public Task(
                    String title,
                    String description,
                    LocalDateTime dueDate,
                    TaskStatus status,
                    Priority priority,
                    User assignedUser,
                    Team team)
                     {

            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.status = status;
            this.priority = priority;
            this.assignedUser = assignedUser;
            this.team = team;
        }

        public Long getId() {
            return id;
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

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public LocalDateTime getDueDate() {
            return dueDate;
        }

        public void setDueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }


        public TaskStatus getStatus() {
            return status;
        }

        public void setStatus(TaskStatus status) {
            this.status = status;
        }

        public Priority getPriority() {
            return priority;
        }

        public void setPriority(Priority priority) {
            this.priority = priority;
        }

        public User getAssignedUser() {
            return assignedUser;
        }

        public void setAssignedUser(User assignedUser) {
            this.assignedUser = assignedUser;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public List<Attachment> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<Attachment> attachments) {
            this.attachments = attachments;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }
    }
