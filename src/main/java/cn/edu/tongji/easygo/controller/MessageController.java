package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Message;
import cn.edu.tongji.easygo.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("api/v1/message")
@RestController
@CrossOrigin
@Api(value="消息",tags = "消息",description = "消息")
public class MessageController {
    @Resource
    MessageService messageService;

    @ApiOperation("发送消息")
    @PostMapping("")
    public ResponseEntity<Object> sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
        return ResponseEntity.status(200).body("发送消息成功");
    }

    @ApiOperation("删除消息")
    @DeleteMapping("{messageId}")
    public ResponseEntity<Object> deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
        return ResponseEntity.status(200).body("删除消息成功");
    }

    @ApiOperation("查询某用户的消息")
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> showMessageByUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(200).body(messageService.showAllMessageByUser(userId));
    }

    @ApiOperation("查看某消息")
    @GetMapping("{messageId}")
    public ResponseEntity<Object> showConcreteMessage(@PathVariable("messageId") Long messageId) {
        return ResponseEntity.status(200).body(messageService.showAllMessageByUser(messageId));
    }

    @ApiOperation("修改某消息")
    @PutMapping("{messageId}")
    public ResponseEntity<Object> readMessage(@PathVariable("messageId") Long messageId) {
        messageService.readMessage(messageId);
        return ResponseEntity.status(200).body("消息已读成功");
    }
}
