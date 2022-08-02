package com.jklearn.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.domain.Sorts;
import com.jklearn.blog.service.SortsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sorts")
public class SortsController {
    @Resource
    private SortsService sortsService;

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
}
