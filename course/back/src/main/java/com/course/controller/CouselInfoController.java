package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.qo.CouselInfoQo;
import com.course.qo.KexamresInfoQo;
import com.course.service.CouselInfoService;
import com.course.service.KexamresInfoService;
import com.course.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CouselInfoController {

    @Autowired
    private CouselInfoService couselInfoService;
    @Autowired
    private KexamresInfoService kexamresInfoService;

    @RequestMapping("/cousel/showcouselbystudentid")
    public String couselShowCouselByStudentId(@RequestBody CouselInfoQo couselInfoQo){
        List<CourseInfoVo> courseInfoVoList = couselInfoService.showCourseByCousel(couselInfoQo);
        return AjaxJsonDto.success("",courseInfoVoList);
    }


    @RequestMapping("/cousel/countexam")
    public String couselCountExam(@RequestBody CouselInfoQo couselInfoQo){

        int allCount=couselInfoService.selectCouselNum(couselInfoQo);
        KexamresInfoQo kexamresInfoQo=new KexamresInfoQo();
        kexamresInfoQo.setExamId(couselInfoQo.getExamId()+"");
        int examCount=kexamresInfoService.countZuoDaNum(kexamresInfoQo);
        List<Integer> integerList=new ArrayList<>();
        integerList.add(examCount);
        integerList.add(allCount-examCount);
        System.out.println(integerList);
        return AjaxJsonDto.success("",integerList);

    }
}
