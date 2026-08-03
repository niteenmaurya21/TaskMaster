package org.niteen.tasktracker.mapper;


import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;
import org.niteen.tasktracker.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentDTO toDto(Comment comment) {
        if (comment == null) {return null;}
        CommentDTO dto = new CommentDTO();

        dto.setId(comment.getId());
        dto.setMessage(comment.getMessage());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());

        if (comment.getAuthor() != null) {
            dto.setAuthorId(comment.getAuthor().getId());
            dto.setAuthorName(comment.getAuthor().getName());
        }

        if (comment.getTask() != null) {
            dto.setTaskId(comment.getTask().getId());
        }

        return dto;
    }
    public Comment toEntity(CreateCommentRequest request) {

        if (request == null) {
            return null;
        }

        Comment comment = new Comment();

        comment.setMessage(request.getMessage());

        // Author and Task will be set in the Service layer
        // after fetching them from their repositories.

        return comment;
    }
}
