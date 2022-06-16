package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.CouselInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.CouselInfoQo;
import com.course.service.CourseInfoService;
import com.course.service.CouselInfoService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouselInfoController {
    @Autowired
    private CouselInfoService couselInfoService;
    @Autowired
    private CourseInfoService courseInfoService;

     @RequestMapping("cousel/selecthascourse")
    public String couselSelectHasCourse(@RequestBody CouselInfoQo couselInfoQo){
         CouselInfo couselInfo=couselInfoService.selectStudentHasCourse(couselInfoQo);
         if(couselInfo!=null){
             return AjaxJsonDto.success("");
         }
         return AjaxJsonDto.fail("");
     }



     @RequestMapping("/cousel/addcousel")
    public String couselAddCousel(@RequestBody CouselInfoQo couselInfoQo){
         int result=couselInfoService.addCousel(couselInfoQo);
         CourseInfoQo courseInfoQo=new CourseInfoQo();
         courseInfoQo.setCourseId(couselInfoQo.getCourseId());
         result=courseInfoService.updateSelectNum(courseInfoQo);
         if(result>0){
             return AjaxJsonDto.success("选课成功");
         }
         return AjaxJsonDto.fail("选课失败");
     }
}
