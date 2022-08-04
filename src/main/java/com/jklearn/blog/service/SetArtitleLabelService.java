package com.jklearn.blog.service;

import com.jklearn.blog.domain.SetArtitleLabel;

import java.util.List;

public interface SetArtitleLabelService{


    List<SetArtitleLabel> queryById(String articleId);
}
