package cn.edu.tongji.easygo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.easygo.dto.UserLoginDTO;
import cn.edu.tongji.easygo.dto.UserRegisterDTO;
import cn.edu.tongji.easygo.model.User;
import cn.edu.tongji.easygo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
@Api(value="用户",tags = "用户",description = "用户")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("登录")
    @GetMapping("login")
    public ResponseEntity<Object> login(@RequestParam("userId") Long userId, @RequestParam("userPassword") String password) {
        UserLoginDTO info = new UserLoginDTO();
        User loginUser = userService.login(userId, password);
        if (loginUser != null) {
            StpUtil.login(userId);
            info.setUserId(loginUser.getUserId());
            info.setUserName(loginUser.getUserName());
            info.setUserAvatar(loginUser.getUserAvatar());
            info.setResult("登录成功");
            info.setToken(StpUtil.getTokenValue());
            return ResponseEntity.status(200).body(info);
        } else {
            return ResponseEntity.status(200).body("登录失败");
        }
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody UserRegisterDTO registerInfo) {
        if (userService.register(registerInfo) != null)
            return ResponseEntity.status(200).body("注册成功");
        else
            return ResponseEntity.status(200).body("注册失败");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @ApiOperation("查询所有用户信息")
    @GetMapping("")
    public ResponseEntity<Object> showAllUsers() {
        if (!StpUtil.hasRole("admin"))
            return ResponseEntity.status(200).body("您无权操作");
        return ResponseEntity.status(200).body(userService.showAllUser());
    }

    @ApiOperation("查询某用户信息")
    @GetMapping("{userId}")
    public ResponseEntity<Object> showConcreteUser(@PathVariable("userId") Long userId) {
        try {
            return ResponseEntity.status(200).body(userService.showConcreteUser(userId));
        } catch (Exception e) {
            return ResponseEntity.status(200).body("返回失败");
        }
    }

    @ApiOperation("修改某用户信息")
    @PutMapping("{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") Long userId, @RequestBody User updateUserInfo) {
        try {
            userService.updateUser(userId , updateUserInfo);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(200).body("修改失败");
        }
    }
}
