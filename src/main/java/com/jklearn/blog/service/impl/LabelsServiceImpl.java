package com.jklearn.blog.service.impl;

import com.jklearn.blog.domain.Labels;
import com.jklearn.blog.mapper.SetArtitleLabelMapper;
import com.jklearn.blog.utils.DateTimeUtil;
import com.jklearn.blog.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.LabelsMapper;
import com.jklearn.blog.service.LabelsService;

import java.util.List;
import java.util.UUID;

@Service
public class LabelsServiceImpl implements LabelsService{

    @Resource
    private LabelsMapper labelsMapper;

    @Resource
    private SetArtitleLabelMapper setArtitleLabelMapper;

    @Override
    public List<Labels> selectAll() {
        return labelsMapper.selectAll();
    }

    @Override
    public int insertOneLabel(String labelName) {
        Labels label = new Labels();
        label.setLabelId(UUIDUtil.getUUID());
        label.setLabelName(labelName);
        label.setLabelCreatedate(DateTimeUtil.getSysTime());
        return labelsMapper.insertSelective(label);
    }

    @Override
    public int updateLabel(Labels label) {
        return labelsMapper.updateByPrimaryKeySelective(label);
    }

    @Override
    public int deleteOneLabel(String id) {
        setArtitleLabelMapper.removeAllByLabelKey(id);
        return labelsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Labels selectLabelById(String labelId) {
        return labelsMapper.selectByPrimaryKey(labelId);
    }


}
