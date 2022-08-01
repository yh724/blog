package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "labels")
public class Labels {
    /**
     * 标签ID
     */
    @Id
    @Column(name = "label_id")
    private String labelId;

    /**
     * 标签名称
     */
    @Column(name = "label_name")
    private String labelName;

    /**
     * 标签描述
     */
    @Column(name = "label_description")
    private String labelDescription;
}