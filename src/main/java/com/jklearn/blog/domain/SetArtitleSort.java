package com.jklearn.blog.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "set_artitle_sort")
public class SetArtitleSort {
    /**
     * 文章ID
     */
    @Id
    @Column(name = "article_id")
    private String articleId;

    /**
     * 分类ID
     */
    @Column(name = "sort_id")
    private String sortId;
}