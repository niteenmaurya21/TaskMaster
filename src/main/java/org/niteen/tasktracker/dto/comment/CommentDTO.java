package org.niteen.tasktracker.dto.comment;

import java.time.LocalDateTime;

public class CommentDTO {
    private Long id;

    private String message;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long authorId;

    private String authorName;

    private Long taskId;

    public CommentDTO(Long id,
                      String message,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt,
                      Long authorId,
                      String authorName,
                      Long taskId) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.authorId = authorId;
        this.authorName = authorName;
        this.taskId = taskId;
    }

    public CommentDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
