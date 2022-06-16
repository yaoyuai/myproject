package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.MaterialInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.MaterialInfoQo;
import com.course.service.MaterialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialInfoController {


    @Autowired
    private MaterialInfoService materialInfoService;

    @RequestMapping("/material/show")
    public String materialShow(@RequestBody CourseInfoQo courseInfoQo){

        MaterialInfoQo materialInfoQo=new MaterialInfoQo();
        materialInfoQo.setCourseId(courseInfoQo.getCourseId());

        List<MaterialInfo> materialInfoList = materialInfoService.showAllMaterialById(materialInfoQo);

        return AjaxJsonDto.success("",materialInfoList);


    }



}
