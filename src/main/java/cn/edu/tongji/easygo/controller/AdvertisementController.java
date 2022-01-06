package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Advertisement;
import cn.edu.tongji.easygo.service.AdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/advertisement")
@RestController
@CrossOrigin
@Api(value="广告",tags = "广告",description = "广告")
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    @ApiOperation("添加广告")
    @PostMapping("")
    public ResponseEntity<Object> addAdvertisement(@RequestBody Advertisement advertisement){
        advertisementService.addAdvertisement(advertisement);
        return ResponseEntity.status(200).body("添加成功");
    }

    @ApiOperation("删除某需求/物品")
    @DeleteMapping("{advertisementId}")
    public ResponseEntity<Object> deleteAdvertisement(@PathVariable Long advertisementId){
        advertisementService.deleteAdvertisement(advertisementId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @ApiOperation("分页查询所有广告信息")
    @GetMapping("{pageNum}/{sizeNum}")
    public ResponseEntity<Object> showAllAdvertisements(@PathVariable Integer pageNum,
                                                        @PathVariable Integer sizeNum){
        try{
            List<Advertisement> advertisements = advertisementService.showAllAdvertisement(pageNum, sizeNum);
            return ResponseEntity.status(200).body(advertisements);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(-1).body("查询失败");
        }
    }

    @ApiOperation("查询某广告信息")
    @GetMapping("{advertisementId}")
    public ResponseEntity<Object> showAdvertisement(@PathVariable("advertisementId") Long advertisementId){
        Advertisement advertisement = advertisementService.showConcreteAdvertisement(advertisementId);
        return ResponseEntity.status(200).body(advertisement);
    }

    @ApiOperation("修改某广告信息")
    @PutMapping("{advertisementId}")
    public ResponseEntity<Object> updateAdvertisement(@PathVariable("advertisementId") Long advertisementId,@RequestBody Advertisement advertisement){
        try {
            advertisementService.updateAdvertisement(advertisementId,advertisement);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(-1).body("修改失败");
        }
    }

    @ApiOperation("查询展示到首页的（state为1）的广告信息")
    @GetMapping("front")
    public ResponseEntity<Object> frontAdvertisements(){
        List<Advertisement> advertisements = advertisementService.showFrontAdvertisement();
        return ResponseEntity.status(200).body(advertisements);
    }

}
