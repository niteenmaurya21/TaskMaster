package org.niteen.tasktracker.service.attachment;

import org.niteen.tasktracker.dto.attachment.AttachmentDTO;
import org.niteen.tasktracker.dto.attachment.UploadAttachmentRequest;
import org.niteen.tasktracker.mapper.AttachmentMapper;
import org.niteen.tasktracker.repository.AttachmentRepository;
import org.niteen.tasktracker.repository.TaskRepository;
import org.niteen.tasktracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public AttachmentServiceImpl(
            AttachmentRepository attachmentRepository,
            AttachmentMapper attachmentMapper,
            TaskRepository taskRepository,
            UserRepository userRepository) {

        this.attachmentRepository = attachmentRepository;
        this.attachmentMapper = attachmentMapper;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AttachmentDTO uploadAttachment(
            Long taskId,
            UploadAttachmentRequest request) {
        return null;
    }

    @Override
    public List<AttachmentDTO> getAttachments(Long taskId) {
        return List.of();
    }

    @Override
    public void deleteAttachment(Long attachmentId) {

    }
}