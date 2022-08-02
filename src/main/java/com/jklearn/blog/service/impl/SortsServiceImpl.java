package com.jklearn.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.jklearn.blog.domain.Sorts;
import com.jklearn.blog.utils.DateTimeUtil;
import com.jklearn.blog.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.SortsMapper;
import com.jklearn.blog.service.SortsService;

import java.util.List;

@Service
public class SortsServiceImpl implements SortsService{

    @Resource
    private SortsMapper sortsMapper;

    @Override
    public List<Sorts> selectSorts(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return sortsMapper.selectAll();
    }

    @Override
    public String insertSort(Sorts sort) {
        String message="error";
        sort.setSortId(UUIDUtil.getUUID());
        sort.setSortCreateDate(DateTimeUtil.getSysTime());
        sort.setSortEditBy(sort.getSortCreateBy());
        sort.setSortEditDate(DateTimeUtil.getSysTime());
        int res = sortsMapper.insertSelective(sort);
        if(res == 1 ){
            message = "success";
        }
        return message;
    }

    @Override
    public String updateSort(Sorts sort) {
        String message="error";
        sort.setSortEditBy(sort.getSortCreateBy());
        sort.setSortEditDate(DateTimeUtil.getSysTime());
        int res = sortsMapper.updateByPrimaryKeySelective(sort);
        if(res == 1 ){
            message = "success";
        }
        return message;
    }
}
