package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sorts")
public class Sorts {
    /**
     * 分类ID
     */
    @Id
    @Column(name = "sort_id")
    private String sortId;

    /**
     * 分类名称
     */
    @Column(name = "sort_name")
    private String sortName;

    /**
     * 分类描述
     */
    @Column(name = "sort_description")
    private String sortDescription;
}