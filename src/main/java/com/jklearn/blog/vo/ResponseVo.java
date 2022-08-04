package com.jklearn.blog.vo;

import com.jklearn.blog.domain.Articles;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseVo {
    private String articleId;
    private String userId;
    private String articleTitle;
    private String articleSortId;
    private ArrayList<String> articleLabelIds;
    private String articleContent;
}
