package cn.edu.tongji.easygo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.easygo.model.Admin;
import cn.edu.tongji.easygo.service.AdminService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin
@Api(value="管理员",tags = "管理员",description = "管理员")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ApiOperation("登录")
    @GetMapping("login")
    public Result login(@RequestParam("adminId") Long adminId, @RequestParam("adminPassword") String adminPassword) {
        Admin admin = adminService.login(adminId,adminPassword);
        if(admin!=null){
            //管理员登录逻辑是否和用户一样

            return Result.wrapSuccessfulResult("");
        }
        else{
            return Result.wrapErrorResult("登录失败");
        }
    }


}
