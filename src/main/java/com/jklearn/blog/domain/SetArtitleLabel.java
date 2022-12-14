package com.jklearn.blog.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "set_artitle_label")
public class SetArtitleLabel {
    /**
     * 文章ID
     */
    @Id
    @Column(name = "article_id")
    private String articleId;

    @Id
    @Column(name = "label_id")
    private String labelId;
}