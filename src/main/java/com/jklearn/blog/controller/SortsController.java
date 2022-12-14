package com.jklearn.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.jklearn.blog.domain.Sorts;
import com.jklearn.blog.exception.BlogEnum;
import com.jklearn.blog.service.SortsService;
import com.jklearn.blog.vo.CommonReturnType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sorts")
public class SortsController {
    @Resource
    private SortsService sortsService;

    @GetMapping
    public List<Sorts> selectAll(){
        return sortsService.selectAll();
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public String getSorts(@PathVariable Integer currentPage,
                              @PathVariable Integer pageSize){
        String json = "";
        ObjectMapper om = new ObjectMapper();
        List<Sorts> articlesList = sortsService.selectSorts(currentPage,pageSize);
        PageInfo<Sorts> pageInfo = new PageInfo<>(articlesList);
        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("total",pageInfo.getTotal());
        resMap.put("sortsList",articlesList);
        try {
            json = om.writeValueAsString(resMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @PostMapping
    public String insertSort(@RequestBody Sorts sort){
        return sortsService.insertSort(sort);
    }

    @PutMapping
    public String updateSort(@RequestBody Sorts sort){
        return sortsService.updateSort(sort);
    }

    @DeleteMapping("/{id}")
    public <T> CommonReturnType<T> deleteSort(@PathVariable String id){
        int res = sortsService.deleteSort(id);
        if(res == 1){
            return CommonReturnType.success(null);
        }else {
            return CommonReturnType.fail(BlogEnum.SORT_DELETE);
        }
    }
}
