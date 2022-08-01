package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.CommentsMapper;
import com.jklearn.blog.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsMapper commentsMapper;

}
