package com.maoyan.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.maoyan.execption.CustomException;
import com.maoyan.mapper.TestUserMapper;
import com.maoyan.model.TestUser;
import com.maoyan.model.TestUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl {

    @Autowired
    private TestUserMapper testUserMapper;

    public SaTokenInfo login(String username, String password) {
        // 密码加密
        String md5Password = SaSecureUtil.md5(password);
        TestUserExample userExample = new TestUserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(md5Password);
        List<TestUser> testUsers = testUserMapper.selectByExample(userExample);
        if (testUsers.isEmpty()) {
            throw new CustomException("用户名或密码错误");
        }
        StpUtil.login(testUsers.get(0).getId(), true);
        return StpUtil.getTokenInfo();
    }
}
