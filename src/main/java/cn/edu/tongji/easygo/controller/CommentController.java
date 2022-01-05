package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Comment;
import cn.edu.tongji.easygo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("api/v1/comment")
@RestController
@CrossOrigin
@Api(value="评论",tags = "评论",description = "评论")
public class CommentController {
    @Resource
    CommentService commentService;

    @ApiOperation("添加评论")
    @PostMapping("")
    public ResponseEntity<Object> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResponseEntity.status(200).body("评论成功");
    }

    @ApiOperation("删除评论")
    @DeleteMapping("{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @ApiOperation("查看某需求、物品的评论")
    @GetMapping("information/{informationId}")
    public ResponseEntity<Object> showCommentByInformation(@PathVariable("informationId") Long informationId) {
        return ResponseEntity.status(200).body(commentService.showCommentByInformation(informationId));
    }

    @ApiOperation("查看某评论的信息")
    @GetMapping("{commentId}")
    public ResponseEntity<Object> showComment(@PathVariable("commentId") Long commentId) {
        return ResponseEntity.status(200).body(commentService.showComment(commentId));
    }
}
