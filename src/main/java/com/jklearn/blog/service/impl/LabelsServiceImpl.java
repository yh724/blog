package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.LabelsMapper;
import com.jklearn.blog.service.LabelsService;
@Service
public class LabelsServiceImpl implements LabelsService{

    @Resource
    private LabelsMapper labelsMapper;

}
