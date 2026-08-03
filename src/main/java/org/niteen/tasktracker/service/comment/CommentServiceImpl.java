package org.niteen.tasktracker.service.comment;

import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;
import org.niteen.tasktracker.mapper.CommentMapper;
import org.niteen.tasktracker.repository.CommentRepository;
import org.niteen.tasktracker.repository.TaskRepository;
import org.niteen.tasktracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(
            CommentRepository commentRepository,
            CommentMapper commentMapper,
            TaskRepository taskRepository,
            UserRepository userRepository) {

        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommentDTO addComment(Long taskId, CreateCommentRequest request) {
        return null;
    }

    @Override
    public List<CommentDTO> getCommentsByTask(Long taskId) {
        return List.of();
    }

    @Override
    public void deleteComment(Long commentId) {

    }
}