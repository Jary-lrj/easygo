package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin
@Api(value="管理员",tags = "管理员",description = "管理员")
public class AdminController {
    @Autowired
    AdminService adminService;



}
