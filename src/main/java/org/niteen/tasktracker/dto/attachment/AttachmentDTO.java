package org.niteen.tasktracker.dto.attachment;

import java.time.LocalDateTime;

public class AttachmentDTO {
    private Long id;

    private String filename;

    private String filePath;

    private LocalDateTime uploadedAt;

    private Long uploadedById;

    private String uploadedByName;

    private Long taskId;

    public AttachmentDTO(Long id,
                         String filename,
                         String filePath,
                         LocalDateTime uploadedAt,
                         Long uploadedById,
                         String uploadedByName,
                         Long taskId) {
        this.id = id;
        this.filename = filename;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
        this.uploadedById = uploadedById;
        this.uploadedByName = uploadedByName;
        this.taskId = taskId;
    }

    public AttachmentDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Long getUploadedById() {
        return uploadedById;
    }

    public void setUploadedById(Long uploadedById) {
        this.uploadedById = uploadedById;
    }

    public String getUploadedByName() {
        return uploadedByName;
    }

    public void setUploadedByName(String uploadedByName) {
        this.uploadedByName = uploadedByName;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
