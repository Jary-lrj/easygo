package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Email;
import cn.edu.tongji.easygo.service.ServiceImpl.EmailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("api/v1/email")
@CrossOrigin
public class EmailController {
    @Resource
    EmailServiceImpl emailService;

    @PostMapping("")
    public ResponseEntity<String> sendEmail(String mailFrom, @RequestBody Email email) {
        emailService.sendEmail("goeasy2022@163.com", email);
        System.out.println(email.getMailTo());
        System.out.println(email.getSubject());
        System.out.println(email.getMailCc());
        System.out.println(email.getContent());
        return ResponseEntity.ok("发送成功");
    }
}
