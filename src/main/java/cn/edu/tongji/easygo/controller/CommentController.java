package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Comment;
import cn.edu.tongji.easygo.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("api/v1/comment")
@RestController
public class CommentController {
    @Resource
    CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Object> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResponseEntity.status(200).body("评论成功");
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @GetMapping("information/{informationId}")
    public ResponseEntity<Object> showCommentByInformation(@PathVariable("informationId") Long informationId) {
        return ResponseEntity.status(200).body(commentService.showCommentByInformation(informationId));
    }

    @GetMapping("{commentId}")
    public ResponseEntity<Object> showComment(@PathVariable("commentId") Long commentId) {
        return ResponseEntity.status(200).body(commentService.showComment(commentId));
    }
}
