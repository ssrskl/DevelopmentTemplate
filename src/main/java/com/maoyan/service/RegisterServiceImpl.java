package com.maoyan.service;


import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.maoyan.execption.CustomException;
import com.maoyan.mapper.TestUserMapper;
import com.maoyan.model.TestUser;
import com.maoyan.model.vo.RegisterUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl {

    @Autowired
    private TestUserMapper testUserMapper;

    public int register(RegisterUserVO registerUserVO) {
        // 密码加密
        String md5Password = SaSecureUtil.md5(registerUserVO.getPassword());
        TestUser testUser = new TestUser();
        BeanUtil.copyProperties(registerUserVO, testUser);
        testUser.setPassword(md5Password);
        testUser.setUpdateTime(new DateTime());
        testUser.setCreateTime(new DateTime());
        int insert = testUserMapper.insert(testUser);
        if (insert <= 0) {
            throw new CustomException("注册失败");
        }
        return insert;
    }

}
