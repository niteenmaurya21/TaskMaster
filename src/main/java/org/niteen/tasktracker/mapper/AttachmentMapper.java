package org.niteen.tasktracker.mapper;

import org.niteen.tasktracker.dto.attachment.AttachmentDTO;
import org.niteen.tasktracker.dto.attachment.UploadAttachmentRequest;
import org.niteen.tasktracker.entity.Attachment;
import org.springframework.stereotype.Component;

@Component
public class AttachmentMapper {
    public AttachmentDTO toDto(Attachment attachment) {
        if (attachment == null) {return null;}
        AttachmentDTO dto = new AttachmentDTO();

        dto.setId(attachment.getId());
        dto.setFilename(attachment.getFilename());
        dto.setFilePath(attachment.getFilePath());
        dto.setUploadedAt(attachment.getUploadedAt());

        if (attachment.getUploadedBy() != null) {
            dto.setUploadedById(attachment.getUploadedBy().getId());
            dto.setUploadedByName(attachment.getUploadedBy().getName());
        }

        if (attachment.getTask() != null) {
            dto.setTaskId(attachment.getTask().getId());
        }

        return dto;
    }

    public Attachment toEntity(UploadAttachmentRequest request) {

        if (request == null) {
            return null;
        }

        Attachment attachment = new Attachment();

        /*TODO :
         * filename and filePath will come from MultipartFile
         * uploadedBy will be set in the Service layer
         * task will be set in the Service layer
         * uploadedAt is handled by @CreationTimestamp
         */

        return attachment;
    }
}
