package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/information")
@RestController
@CrossOrigin
@Api(value="物品和需求信息",tags = "物品和需求信息",description = "物品和需求信息")
public class InformationController {

    @Autowired
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

    @GetMapping("{informationType}")
    @ApiOperation(value="按类型查询信息列表")
    public ResponseEntity<Object> showInformationByType(@PathVariable Integer informationType){

        return ResponseEntity.status(200).body("");
    }

    //需求，物品
    //图片
    //模糊查询
    //类型查询
    //价格排序
    //查看某用户的供需
    //发布时间排序


}
