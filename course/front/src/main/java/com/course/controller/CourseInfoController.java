package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.qo.CourseInfoQo;
import com.course.service.CourseInfoService;
import com.course.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseInfoController {
    @Autowired
    private CourseInfoService courseInfoService;

    @RequestMapping("/course/selectbycondition")
    public String selectByCondition(CourseInfoQo courseInfoQo){
        System.out.println(courseInfoQo.getNowPage()+"--"+courseInfoQo.getDivideNum());
        List<CourseInfoVo> courseInfoVoList = courseInfoService.showAllCourseByCondition(courseInfoQo);
        int count=courseInfoService.showAllCourseByConditionCount(courseInfoQo);
        System.out.println(courseInfoVoList+"--"+count);
        return AjaxJsonDto.success("",courseInfoVoList,count);
    }

    @RequestMapping("/course/selecthotcourse")
    public String selelctHotCourse(){
        List<CourseInfoVo> courseInfoVoList = courseInfoService.selectHotCourse();
        return AjaxJsonDto.success("",courseInfoVoList);
    }
}
