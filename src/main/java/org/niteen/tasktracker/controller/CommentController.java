package org.niteen.tasktracker.controller;


import jakarta.validation.Valid;
import org.niteen.tasktracker.dto.comment.CommentDTO;
import org.niteen.tasktracker.dto.comment.CreateCommentRequest;
import org.niteen.tasktracker.dto.comment.UpdateCommentRequest;
import org.niteen.tasktracker.service.comment.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/tasks/{taskId}")
    public ResponseEntity<CommentDTO> addComment(@Valid @PathVariable Long taskId, @RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(commentService.addComment(taskId ,request)) ;
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByTask(
            @PathVariable Long taskId) {

        return ResponseEntity.ok(commentService.getCommentsByTask(taskId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable Long commentId,
            @Valid @RequestBody UpdateCommentRequest request) {

        return ResponseEntity.ok(
                commentService.updateComment(commentId, request));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long commentId) {

        commentService.deleteComment(commentId);

        return ResponseEntity.noContent().build();
    }
}
