package com.jklearn.blog.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.SetArtitleSortMapper;
import com.jklearn.blog.service.SetArtitleSortService;
@Service
public class SetArtitleSortServiceImpl implements SetArtitleSortService{

    @Resource
    private SetArtitleSortMapper setArtitleSortMapper;

}
