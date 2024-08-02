package com.maoyan.service;

import com.maoyan.model.TestUser;
import com.maoyan.model.vo.AddUserVO;
import com.maoyan.model.vo.UpdateUserVO;

public interface TestUserService {
    TestUser getUserById(Long userId);

    TestUser getUserByUsernameAndPassword(String username, String password);

    int updateUser(UpdateUserVO userVO);

    int deleteUser(Long userId);

    int insertUser(AddUserVO userVO);
}
