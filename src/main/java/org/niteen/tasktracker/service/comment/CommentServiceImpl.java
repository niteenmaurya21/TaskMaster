package org.niteen.tasktracker.service.comment;

import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;
import org.niteen.tasktracker.entity.Comment;
import org.niteen.tasktracker.entity.Task;
import org.niteen.tasktracker.entity.User;
import org.niteen.tasktracker.exception.CommentNotFoundException;
import org.niteen.tasktracker.exception.TaskNotFoundException;
import org.niteen.tasktracker.exception.UserNotFoundException;
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
        User author = userRepository.findById(request.getAuthorId()).orElseThrow(()->
                new UserNotFoundException("Author not found"));
        Task task = taskRepository.findById(request.getTaskId()).orElseThrow(()->
                new TaskNotFoundException("Task not found"));
        Comment comment = new Comment(
                request.getMessage(),
                author ,
                task
        );

        Comment savedComment = commentRepository.save(comment);


        return commentMapper.toDto(savedComment);
    }

    @Override
    public List<CommentDTO> getCommentsByTask(Long taskId) {
        taskRepository.findById(taskId).orElseThrow(()->
                new TaskNotFoundException("Task with id " + taskId + " not found"));

        List<Comment> comments = commentRepository.findByTask(taskId);


        return comments.stream().map(commentMapper :: toDto).toList();
    }

    @Override
    public void deleteComment(Long commentId) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(()->
                new CommentNotFoundException("Comment with id " + commentId + " not found"));
        commentRepository.delete(comment);

    }

}