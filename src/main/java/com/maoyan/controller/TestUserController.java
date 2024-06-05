package com.maoyan.controller;

import com.maoyan.model.TestUser;
import com.maoyan.service.TestUserService;
import com.maoyan.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @GetMapping(value = "/user")
    public AjaxResult queryUserById(){
        TestUser userById = testUserService.getUserById(1L);
        return AjaxResult.success("查询成功",userById);
    }
}
