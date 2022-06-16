package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.pojo.StudentInfo;
import com.course.qo.StudentInfoQo;
import com.course.service.StudentInfoService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/student/login")
    public String studentLogin(@RequestBody StudentInfoQo studentInfoQo, HttpSession session) {

        String code=studentInfoQo.getCode();
        System.out.println(code+"--");
        if(!code.equalsIgnoreCase(String.valueOf(session.getAttribute("code")))){
            return AjaxJsonDto.fail("验证码输入错误");
        }
        StudentInfo studentInfo = studentInfoService.judgeLogin(studentInfoQo);
        if(studentInfo!=null){
            session.setAttribute("student",studentInfo);
            return AjaxJsonDto.success("登录成功",studentInfo);
        }
        return AjaxJsonDto.fail("登录失败,账号密码有误或您被禁用");
    }



    @RequestMapping("/student/regist")
    public String studentRegist(@RequestBody StudentInfoQo studentInfoQo){

        if(studentInfoService.judgeRegistHasName(studentInfoQo.getStudentName())!=null){
            return AjaxJsonDto.fail("注册失败，用户名已被使用");
        }

        int result=studentInfoService.addStudent(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注册成功,正在前往登录页面");
        }
        return AjaxJsonDto.fail("注册失败，请联系管理员");
    }


    @RequestMapping("/student/exit")
    public String studentExit(HttpSession session){
        session.invalidate();
        return AjaxJsonDto.success("退出成功");
    }
}
