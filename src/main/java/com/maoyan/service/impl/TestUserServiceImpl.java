package com.maoyan.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.maoyan.execption.CustomException;
import com.maoyan.mapper.TestUserMapper;
import com.maoyan.model.TestUser;
import com.maoyan.model.TestUserExample;
import com.maoyan.model.vo.AddUserVO;
import com.maoyan.model.vo.UpdateUserVO;
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
        TestUser testUser = testUserMapper.selectByPrimaryKey(userId);
        if (ObjectUtil.isNull(testUser)) {
            throw new CustomException("用户不存在");
        }
        return testUser;
    }

    @Override
    public TestUser getUserByUsernameAndPassword(String username, String password) {
        TestUserExample testUserExample = new TestUserExample();
        testUserExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<TestUser> testUsers = testUserMapper.selectByExample(testUserExample);
        if (testUsers.isEmpty()) {
            throw new CustomException("用户不存在");
        }
        return testUsers.get(0);
    }

    @Override
    public int updateUser(UpdateUserVO userVO) {
        TestUser testUser = testUserMapper.selectByPrimaryKey(userVO.getId());
        BeanUtil.copyProperties(userVO, testUser);
        testUser.setUpdateTime(new DateTime());
        int i = testUserMapper.updateByPrimaryKey(testUser);

        if (i <= 0) {
            throw new CustomException("更新失败");
        }
        return i;
    }

    @Override
    public int deleteUser(Long userId) {
        int i = testUserMapper.deleteByPrimaryKey(userId);
        if (i <= 0) {
            throw new CustomException("删除失败");
        }
        return i;
    }

    @Override
    public int insertUser(AddUserVO userVO) {
        TestUser testUser = new TestUser();
        BeanUtil.copyProperties(userVO, testUser);
        int insert = testUserMapper.insert(testUser);

        if (insert <= 0) {
            throw new CustomException("添加失败");
        }
        return insert;
    }
}
