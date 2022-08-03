package com.jklearn.blog.controller;


import com.jklearn.blog.domain.Labels;
import com.jklearn.blog.exception.BlogEnum;
import com.jklearn.blog.service.LabelsService;
import com.jklearn.blog.vo.CommonReturnType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/labels")
public class LabelsController {
    @Resource
    private LabelsService labelsService;

    @GetMapping
    public List<Labels> selectLabels(){
        return labelsService.selectAll();
    }

    @PostMapping("/{labelName}")
    public <T> CommonReturnType<T> insertLabel(@PathVariable String labelName){
        int res = labelsService.insertOneLabel(labelName);
        if(res == 1){
            return CommonReturnType.success(null);
        }else {
            return CommonReturnType.fail(BlogEnum.LABEL_INSERT_ERROR);
        }
    }

    @PutMapping
    public <T> CommonReturnType<T> updateLabel(@RequestBody Labels label){
        int res = labelsService.updateLabel(label);
        if(res == 1){
            return CommonReturnType.success(null);
        }else {
            return CommonReturnType.fail(BlogEnum.LABEL_UPDATE_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public <T> CommonReturnType<T> deleteLabel(@PathVariable String id){
        int res = labelsService.deleteOneLabel(id);
        if(res == 1){
            return CommonReturnType.success(null);
        }else {
            return CommonReturnType.fail(BlogEnum.LABEL_DELETE_ERROR);
        }
    }

}
