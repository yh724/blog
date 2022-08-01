package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.UsersMapper;
import com.jklearn.blog.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

}
