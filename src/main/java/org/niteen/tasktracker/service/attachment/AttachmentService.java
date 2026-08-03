package org.niteen.tasktracker.service.attachment;

import org.niteen.tasktracker.dto.attachment.AttachmentDTO;
import org.niteen.tasktracker.dto.attachment.UploadAttachmentRequest;

import java.util.List;

public interface AttachmentService {

    AttachmentDTO uploadAttachment(Long taskId,
                                   UploadAttachmentRequest request);

    List<AttachmentDTO> getAttachments(Long taskId);

    void deleteAttachment(Long attachmentId);
}
