package org.niteen.tasktracker.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCommentRequest {


    @NotBlank(message = "Comment cannot be empty")
    @Size(max = 500, message = "Comment cannot exceed 500 characters")
    private String message;

    @NotNull(message = "Authorid is Required")
    private Long AuthorId;

    @NotNull(message = "taskId is required")
    private Long TaskId;


    public CreateCommentRequest(String message, Long authorId, Long taskId) {
        this.message = message;
        AuthorId = authorId;
        TaskId = taskId;
    }

    public Long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Long authorId) {
        AuthorId = authorId;
    }

    public Long getTaskId() {
        return TaskId;
    }

    public void setTaskId(Long taskId) {
        TaskId = taskId;
    }

    public CreateCommentRequest() {


    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
