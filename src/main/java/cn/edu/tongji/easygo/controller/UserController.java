package cn.edu.tongji.easygo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.easygo.dto.UserLoginDTO;
import cn.edu.tongji.easygo.dto.UserRegisterDTO;
import cn.edu.tongji.easygo.model.User;
import cn.edu.tongji.easygo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Resource
    private UserService userService;

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

    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody UserRegisterDTO registerInfo) {
        if (userService.register(registerInfo) != null)
            return ResponseEntity.status(200).body("注册成功");
        else
            return ResponseEntity.status(200).body("注册失败");
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body("删除成功");
    }

    @GetMapping("")
    public ResponseEntity<Object> showAllUsers() {
        if (!StpUtil.hasRole("admin"))
            return ResponseEntity.status(200).body("您无权操作");
        return ResponseEntity.status(200).body(userService.showAllUser());
    }

    @GetMapping("{userId}")
    public ResponseEntity<Object> showConcreteUser(@PathVariable("userId") Long userId) {
        try {
            return ResponseEntity.status(200).body(userService.showConcreteUser(userId));
        } catch (Exception e) {
            return ResponseEntity.status(200).body("返回失败");
        }
    }

    @PutMapping("{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") Long userId, @RequestBody User updateUserInfo) {
        try {
            userService.updateUser(updateUserInfo);
            return ResponseEntity.status(200).body("修改成功");
        } catch (Exception e) {
            return ResponseEntity.status(200).body("修改失败");
        }
    }
}
