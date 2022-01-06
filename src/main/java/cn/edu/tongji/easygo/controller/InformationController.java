package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("api/v1/information")
@RestController
@CrossOrigin
@Api(value = "需求和物品", tags = "需求和物品", description = "需求和物品")
public class InformationController {

    @Resource
    InformationService informationService;

    @ApiOperation("添加需求/物品")
    @PostMapping("")
    public ResponseEntity<Object> addInformation(@RequestBody Information information) {
        informationService.addInformation(information);
        return ResponseEntity.status(200).body("添加成功");
    }

    @ApiOperation("删除某需求/物品")
    @DeleteMapping("{informationId}")
    public ResponseEntity<Object> deleteInformation(@PathVariable("informationId") Long informationId) {
        informationService.deleteInformation(informationId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @ApiOperation("查询某需求/物品信息")
    @GetMapping("{informationId}")
    public ResponseEntity<Object> showInformation(@PathVariable("informationId") Long informationId) {
        return ResponseEntity.status(200).body(informationService.showInformation(informationId));
    }

    @ApiOperation("修改某需求/物品信息")
    @PutMapping("{informationId}")
    public ResponseEntity<Object> updateInformation(@PathVariable("informationId") Long informationId, @RequestBody Information information) {
        try {
            informationService.updateInformation(informationId, information);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(-1).body("修改失败");
        }
    }

    @ApiOperation("查询需求/物品信息列表")
    @GetMapping("/type/{informationType}")
    public ResponseEntity<Object> showInformationByType(@PathVariable Integer informationType) {
        List<Information> informationList = informationService.findInformationByType(informationType);
        return ResponseEntity.status(200).body(informationList);
    }

    @ApiOperation("查询某用户的需求和物品信息")
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> showInformationByUser(@PathVariable Long userId) {
        List<Information> informationList = informationService.findInformationByUser(userId);
        return ResponseEntity.status(200).body(informationList);
    }

    @ApiOperation("按类型和名称搜索需求/物品信息")
    @GetMapping("search/{informationType}/{content}")
    public ResponseEntity<Object> searchByTypeAndContent(@PathVariable Integer informationType,
                                                         @PathVariable String content) {
        List<Information> informationList = informationService.findInformationByTypeAndContent(informationType, content);
        return ResponseEntity.status(200).body(informationList);
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<Object> searchByKeyword(@PathVariable String keyword) {
        return ResponseEntity.status(200).body(informationService.findInformationByKeyword(keyword));
    }

}
