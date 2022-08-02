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
     * 分类别名
     */
    @Column(name = "sort_alias")
    private String sortAlias;

    /**
     * 分类描述
     */
    @Column(name = "sort_description")
    private String sortDescription;

    /**
     * 分类创建人
     */
    @Column(name = "sort_createBy")
    private String sortCreateBy;

    /**
     * 分类创建时间
     */
    @Column(name = "sort_createDate")
    private String sortCreateDate;

    /**
     * 分类修改人
     */
    @Column(name = "sort_editBy")
    private String sortEditBy;

    /**
     * 分类修改时间
     */
    @Column(name = "sort_editDate")
    private String sortEditDate;
}