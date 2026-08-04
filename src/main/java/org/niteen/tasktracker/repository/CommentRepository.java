package org.niteen.tasktracker.repository;

import org.niteen.tasktracker.entity.Comment;
import org.niteen.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTask(Long taskId);
}
