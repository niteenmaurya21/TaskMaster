package org.niteen.tasktracker.service.comment;

import jakarta.validation.Valid;
import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;
import org.niteen.tasktracker.dto.comment.UpdateCommentRequest;

import java.util.List;

public interface CommentService {

    CommentDTO addComment(Long taskId,
                          CreateCommentRequest request);

    List<CommentDTO> getCommentsByTask(Long taskId);

    void deleteComment(Long commentId);

    CommentDTO updateComment(Long commentId, @Valid UpdateCommentRequest request);
}
