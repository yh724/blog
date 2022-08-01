package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "set_artitle_label")
public class SetArtitleLabel {
    /**
     * 文章ID
     */
    @Id
    @Column(name = "article_id")
    private String articleId;

    @Column(name = "label_id")
    private String labelId;
}