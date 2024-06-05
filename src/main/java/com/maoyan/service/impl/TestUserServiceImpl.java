package com.maoyan.service.impl;

import com.maoyan.mapper.TestUserMapper;
import com.maoyan.model.TestUser;
import com.maoyan.model.TestUserExample;
import com.maoyan.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestUserMapper testUserMapper;

    @Override
    public TestUser getUserById(Long userId) {
        TestUserExample testUserExample = new TestUserExample();
        testUserExample.createCriteria().andUsernameEqualTo("猫颜");
        List<TestUser> testUsers = testUserMapper.selectByExample(testUserExample);
        return testUsers.get(0);
    }
}
