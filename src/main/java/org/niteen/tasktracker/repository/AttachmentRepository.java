package org.niteen.tasktracker.repository;

import org.niteen.tasktracker.entity.Attachment;
import org.niteen.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findByTask(Task task);
}
