package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.service.InformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("api/v1/information")
@RestController
@CrossOrigin
public class InformationController {

    @Resource
    InformationService informationService;

    @PostMapping("")
    public ResponseEntity<Object> addInformation(@RequestBody Information information){
        informationService.addInformation(information);
        return ResponseEntity.status(200).body("添加成功");
    }

    @DeleteMapping("{informationId}")
    public ResponseEntity<Object> deleteInformation(@PathVariable("informationId") Long informationId){
        informationService.deleteInformation(informationId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @GetMapping("{informationId}")
    public ResponseEntity<Object> showInformation(@PathVariable("informationId") Long informationId){
        return ResponseEntity.status(200).body(informationService.showInformation(informationId));
    }

    @PutMapping("{informationId}")
    public ResponseEntity<Object> updateInformation(@PathVariable("informationId") Long informationId,@RequestBody Information information){
        try {
            informationService.updateInformation(information);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(200).body("修改失败");
        }
    }

    @GetMapping("/type/{informationType}")
    public ResponseEntity<Object> showInformationByType(@PathVariable Integer informationType){
        List<Information> informationList = informationService.findInformationByType(informationType);
        return ResponseEntity.status(200).body(informationList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> showInformationByUser(@PathVariable Long userId){
        List<Information> informationList = informationService.findInformationByUser(userId);
        return ResponseEntity.status(200).body(informationList);
    }

    //按类型和名称搜索（模糊查询）
    @GetMapping("search/{informationType}/{content}")
    public ResponseEntity<Object> searchByTypeAndContent(@PathVariable Integer informationType,
                                                         @PathVariable String content){
        List<Information> informationList = informationService.findInformationByTypeAndContent(informationType,content);
        return ResponseEntity.status(200).body(informationList);
    }



}
