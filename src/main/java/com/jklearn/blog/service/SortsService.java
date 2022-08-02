package com.jklearn.blog.service;

import com.jklearn.blog.domain.Sorts;

import java.util.List;

public interface SortsService{

    List<Sorts> selectSorts(Integer currentPage, Integer pageSize);

    String insertSort(Sorts sort);

    String updateSort(Sorts sort);
}
