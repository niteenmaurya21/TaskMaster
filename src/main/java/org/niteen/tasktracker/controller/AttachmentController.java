package org.niteen.tasktracker.controller;


import jakarta.validation.Valid;
import org.niteen.tasktracker.dto.attachment.AttachmentDTO;
import org.niteen.tasktracker.dto.attachment.UploadAttachmentRequest;
import org.niteen.tasktracker.service.attachment.AttachmentService;
import org.niteen.tasktracker.service.task.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/tasks/{taskId}")
    public ResponseEntity<AttachmentDTO> uploadAttachment
            (@PathVariable Long taskId,
             @Valid @RequestBody UploadAttachmentRequest request)
    {
        return  ResponseEntity.ok(attachmentService.uploadAttachment(taskId, request));
    }
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<List<AttachmentDTO>> getAttachments(@PathVariable long taskId)
    {
        return ResponseEntity.ok(attachmentService.getAttachments(taskId));
    }
    @DeleteMapping("/{attachmentId}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable long attachmentId)
    {
        attachmentService.deleteAttachment(attachmentId);
        return ResponseEntity.ok().build();
    }
}
