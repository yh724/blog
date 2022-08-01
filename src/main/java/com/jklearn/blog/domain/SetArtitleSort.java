package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "set_artitle_sort")
public class SetArtitleSort {
    /**
     * 文章ID
     */
    @Column(name = "article_id")
    private String articleId;

    /**
     * 分类ID
     */
    @Column(name = "sort_id")
    private String sortId;
}