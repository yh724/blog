package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.SetArtitleLabelMapper;
import com.jklearn.blog.service.SetArtitleLabelService;
@Service
public class SetArtitleLabelServiceImpl implements SetArtitleLabelService{

    @Resource
    private SetArtitleLabelMapper setArtitleLabelMapper;

}
