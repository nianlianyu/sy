package edu.fdzc.mall.user.controller;

import edu.fdzc.mall.entity.Result;
import edu.fdzc.mall.user.entity.User;
import edu.fdzc.mall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        return user == null ? Result.error("用户名或者密码错误！") : Result.success(user);
    }

    @PostMapping("/logout")
    public Result<String> logout(@RequestHeader(value = "Authorization", required = false) String token) {
        return Result.success("退出成功");
    }

    // 添加健康检查接口（前端需要）
    @GetMapping("/health")
    public String health() {
        return "User Service is healthy!";
    }
}