package org.niteen.tasktracker.service.comment;

import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;

import java.util.List;

public interface CommentService {

    CommentDTO addComment(Long taskId,
                          CreateCommentRequest request);

    List<CommentDTO> getCommentsByTask(Long taskId);

    void deleteComment(Long commentId);
}
