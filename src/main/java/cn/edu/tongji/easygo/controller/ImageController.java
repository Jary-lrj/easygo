package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin
@Api(value="图片",tags = "图片",description = "图片")
public class ImageController {
    @Autowired
    ImageService imageService;

    @ApiOperation("为某information或者comment（type分别为0、1）添加图片")
    @PostMapping("addImage/{type}/{id}/{imageUrl}")
    public ResponseEntity<Object> addImage(@PathVariable Integer type,
                                           @PathVariable Long id,
                                           @PathVariable String imageUrl){
        if(type!=0&&type!=1)
            return ResponseEntity.status(200).body("添加失败");

        try {
            boolean flag = imageService.addImage(id, imageUrl, type);
            if(flag)
                return ResponseEntity.status(200).body("添加成功");
            else
                return ResponseEntity.status(200).body("已经添加过");
        }catch(Exception e){
            return ResponseEntity.status(200).body("添加失败");
        }
    }

    @ApiOperation("查询某information或者comment（type分别为0、1）的图片列表")
    @GetMapping("images/{type}/{id}")
    public ResponseEntity<Object> showImages(@PathVariable Integer type,
                                             @PathVariable Long id){
        List<String> images = imageService.showImages(id,type);
        return ResponseEntity.status(200).body(images);
    }

    @ApiOperation("删除某information或者comment（type分别为0、1）的图片")
    @DeleteMapping("images/{type}/{id}")
    public ResponseEntity<Object> deleteImages(@PathVariable Integer type,
                                               @PathVariable Long id){
        boolean flag = imageService.deleteImages(id,type);
        if(flag)
            return ResponseEntity.status(200).body("删除成功");
        else
            return ResponseEntity.status(200).body("删除失败");
    }
}
