package com.jklearn.blog.service.impl;

import com.jklearn.blog.domain.SetArtitleLabel;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.SetArtitleLabelMapper;
import com.jklearn.blog.service.SetArtitleLabelService;

import java.util.List;

@Service
public class SetArtitleLabelServiceImpl implements SetArtitleLabelService{

    @Resource
    private SetArtitleLabelMapper setArtitleLabelMapper;

    @Override
    public List<SetArtitleLabel> queryById(String articleId) {
        return setArtitleLabelMapper.selectWithArticleId(articleId);
    }
}
