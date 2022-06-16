package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.StudentInfo;
import com.course.qo.ExamInfoQo;
import com.course.service.ExamInfoService;
import com.course.vo.ExamInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ExamInfoController {
    @Autowired
    private ExamInfoService examInfoService;

    @RequestMapping("/exam/showallexambycourseid")
    public String examShowAllExamByCourseId(@RequestBody ExamInfoQo examInfoQo, HttpSession session){
        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        examInfoQo.setStudentId(studentInfo.getStudentId()+"");
        List<ExamInfoVo> examInfoVoList= examInfoService.selectAllExamByCourseId(examInfoQo);
        int count=examInfoService.selectAllExamByCourseIdCount(examInfoQo);
        return AjaxJsonDto.success("",examInfoVoList,count);
    }
}
