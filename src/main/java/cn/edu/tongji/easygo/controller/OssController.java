package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.service.OssService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/oss")
@CrossOrigin
public class OssController {
    @Autowired
    OssService ossService;

    @PostMapping
    public ResponseEntity<Object> uploadPic(@RequestParam MultipartFile file)
    {
        String url = ossService.uploadFilePic(file);
        return ResponseEntity.status(200).body(url);
    }
}
