package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.SortsMapper;
import com.jklearn.blog.service.SortsService;
@Service
public class SortsServiceImpl implements SortsService{

    @Resource
    private SortsMapper sortsMapper;

}
