package cn.edu.tongji.easygo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin
@Api(value="图片",tags = "图片",description = "图片")
public class ImageController {

}
