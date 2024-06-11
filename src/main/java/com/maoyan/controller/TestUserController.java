package com.maoyan.controller;

import com.maoyan.model.TestUser;
import com.maoyan.service.TestUserService;
import com.maoyan.utils.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "测试 API", description = "测试接口")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @GetMapping(value = "/user")
    @Operation(summary = "查询用户信息", description = "根据用户ID查询用户信息")
    public AjaxResult queryUserById() {
        TestUser userById = testUserService.getUserById(1L);
        return AjaxResult.success("查询成功", userById);
    }
}
