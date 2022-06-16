package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.StudentInfo;
import com.course.qo.KexamresInfoQo;
import com.course.service.KexamresInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class KexamresInfoController {


    @Autowired
    private KexamresInfoService kexamresInfoService;


    @RequestMapping("/kexamres/add")
    public String kexamResAdd(@RequestBody KexamresInfoQo kexamresInfoQo, HttpSession session){
        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        kexamresInfoQo.setStudentId(studentInfo.getStudentId()+"");
        int result=kexamresInfoService.addKexamResInfo(kexamresInfoQo);
        if(result>0){
            return AjaxJsonDto.success("提交成功");
        }
        return AjaxJsonDto.fail("提交失败");
    }

}
