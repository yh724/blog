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
     * 标签别名
     */
    @Column(name = "label_alias")
    private String labelAlias;

    /**
     * 标签描述
     */
    @Column(name = "label_description")
    private String labelDescription;

    /**
     * 标签创建人
     */
    @Column(name = "label_createBy")
    private String labelCreateBy;

    /**
     * 标签创建时间
     */
    @Column(name = "label_createDate")
    private String labelCreateDate;

    /**
     * 标签修改人
     */
    @Column(name = "label_editBy")
    private String labelEditBy;

    /**
     * 标签修改时间
     */
    @Column(name = "label_editDate")
    private String labelEditDate;
}