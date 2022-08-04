package com.jklearn.blog.service;

import com.jklearn.blog.domain.Labels;

import java.util.List;

public interface LabelsService{

    List<Labels> selectAll();

    int insertOneLabel(String labelName);

    int updateLabel(Labels label);

    int deleteOneLabel(String id);

    Labels selectLabelById(String labelId);
}
