package com.jklearn.blog.service.impl;

import com.jklearn.blog.domain.Users;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.UsersMapper;
import com.jklearn.blog.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users selectUserById(String userId) {
        return usersMapper.selectByPrimaryKey(userId);
    }
}
