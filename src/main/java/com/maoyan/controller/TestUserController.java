package com.maoyan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.maoyan.model.TestUser;
import com.maoyan.model.vo.AddUserVO;
import com.maoyan.model.vo.LoginUserVO;
import com.maoyan.model.vo.RegisterUserVO;
import com.maoyan.model.vo.UpdateUserVO;
import com.maoyan.service.LoginServiceImpl;
import com.maoyan.service.RegisterServiceImpl;
import com.maoyan.service.TestUserService;
import com.maoyan.utils.AjaxResult;
import com.maoyan.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "测试 API", description = "测试接口")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;
    @Autowired
    private LoginServiceImpl loginService; //小型项目推荐直接使用ServiceImpl
    @Autowired
    private RegisterServiceImpl registerService;

    @GetMapping(value = "/user/{id}")
    @Operation(summary = "查询用户信息", description = "根据用户ID查询用户信息")
    public AjaxResult queryUserById(@PathVariable(value = "id") Long id) {
        TestUser userById = testUserService.getUserById(id);
        return AjaxResult.success("查询成功", userById);
    }

    @GetMapping(value = "/user")
    @Operation(summary = "查询当前用户信息", description = "查询当前用户信息")
    @SaCheckLogin
    public Result queryCurrentUser() {
        long loginIdAsLong = StpUtil.getLoginIdAsLong();
        TestUser userById = testUserService.getUserById(loginIdAsLong);
        return Result.ok("查询成功",userById);
//        return AjaxResult.success("查询成功", userById);
    }

    @PostMapping(value = "/login")
    @Operation(summary = "用户登录", description = "用户登录")
    public AjaxResult userLogin(@RequestBody LoginUserVO userVO) {
        SaTokenInfo saTokenInfo = loginService.login(userVO.getUsername(), userVO.getPassword());
        return AjaxResult.success("登录成功", saTokenInfo);
    }

    @GetMapping(value = "/logout")
    @Operation(summary = "用户登出", description = "用户登出")
    @SaCheckLogin
    public AjaxResult logout() {
        StpUtil.logout(); //登出
        return AjaxResult.success("登出成功");
    }

    @PostMapping(value = "/user")
    @Operation(summary = "创建新用户", description = "创建用户")
    public AjaxResult createUser(@RequestBody AddUserVO userVO) {
        int i = testUserService.insertUser(userVO);
        return AjaxResult.success("创建成功", i);
    }

    @PostMapping(value = "/register")
    @Operation(summary = "用户注册", description = "用户注册")
    public AjaxResult register(@RequestBody RegisterUserVO userVO) {
        int register = registerService.register(userVO);
        return AjaxResult.success("注册成功", register);
    }

    @PutMapping(value = "/user")
    @Operation(summary = "更新用户信息", description = "更新用户信息")
    public AjaxResult updateUser(@RequestBody UpdateUserVO userVO) {
        int i = testUserService.updateUser(userVO);
        return AjaxResult.success("更新成功", i);
    }

    @DeleteMapping(value = "/user/{id}")
    @Operation(summary = "删除用户", description = "删除用户信息")
    public AjaxResult deleteUser(@PathVariable("id") Long id) {
        int i = testUserService.deleteUser(id);
        return AjaxResult.success("删除成功", i);
    }
}
