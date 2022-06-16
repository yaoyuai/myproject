package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.ParentInfo;
import com.course.pojo.TeacherInfo;
import com.course.qo.ParentInfoQo;
import com.course.qo.TeacherInfoQo;
import com.course.service.CourseInfoService;
import com.course.service.TeacherInfoService;
import com.course.vo.TeacherInfoVo;
import org.junit.jupiter.api.AfterAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TeacherInfoController {


    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private CourseInfoService courseInfoService;


    @RequestMapping("/teacher/login")
    public String teacherLogin(@RequestBody TeacherInfoQo teacherInfoQo, HttpSession session){

        String code=teacherInfoQo.getCode();
        if(!code.equalsIgnoreCase(String.valueOf(session.getAttribute("code")))){
            return AjaxJsonDto.fail("验证码输入错误");
        }
        TeacherInfo teacherInfo = teacherInfoService.judgeLogin(teacherInfoQo);
        if(teacherInfo!=null){
            session.setAttribute("teacher",teacherInfo);
            return AjaxJsonDto.success("登录成功",teacherInfo);
        }
        return AjaxJsonDto.fail("登录失败,账号密码有误");
    }

    @RequestMapping("/teacher/regist")
    public String teacherRegist(@RequestBody TeacherInfoQo teacherInfoQo){
        //要先去查询一下有没有这个用户
        if(teacherInfoService.judgeHasName(teacherInfoQo.getTeacherName())!=null){
            return AjaxJsonDto.fail("该账户已被注册");
        }
        int result = teacherInfoService.userAddTeacher(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注册成功，请前往登录");
        }
        return AjaxJsonDto.fail("注册失败，请联系管理员");
    }


    @RequestMapping("/teacher/list")
    public String teacherList(TeacherInfoQo teacherInfoQo){
        List<TeacherInfoVo> teacherInfoVoList = teacherInfoService.showAllTeacher(teacherInfoQo);
        int count=teacherInfoService.showAllTeacherCount(teacherInfoQo);
        return AjaxJsonDto.success("",teacherInfoVoList,count);
    }





    @RequestMapping("/teacher/add")
    public String teacherAdd(@RequestBody TeacherInfoQo teacherInfoQo){
        if(teacherInfoService.judgeHasName(teacherInfoQo.getTeacherName())!=null){
            return AjaxJsonDto.fail("该账户已存在");
        }
        int result=teacherInfoService.adminAddTeacher(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("添加成功");
        }
        return AjaxJsonDto.fail("添加失败");
    }


    @RequestMapping("/teacher/update")
    public String teacherUpdate(@RequestBody TeacherInfoQo teacherInfoQo){
        int result=teacherInfoService.adminUpdateTeacher(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新成功");
        }
        return AjaxJsonDto.fail("更新失败");
    }


    @RequestMapping("/teacher/logout")
    public String teacherLogout(@RequestBody TeacherInfoQo teacherInfoQo){
        if(courseInfoService.selectTeacherHasCourse(teacherInfoQo.getTeacherId())!=null){
            return AjaxJsonDto.fail("该教师有发布课程，不能注销");
        }
        int result=teacherInfoService.adminLogOutTeacher(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注销成功");
        }
        return AjaxJsonDto.fail("注销成功");
    }

    @RequestMapping("teacher/resetpwd")
    public String teacherResetPwd(@RequestBody TeacherInfoQo teacherInfoQo){
        int result = teacherInfoService.resetPwd(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("重置密码成功");
        }
        return AjaxJsonDto.fail("重置密码失败");
    }

    @RequestMapping("teacher/updatepwd")
    public String parentUpdatePwd(@RequestBody TeacherInfoQo teacherInfoQo){
        int result=teacherInfoService.updatePwd(teacherInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新密码成功，请重新登录");
        }
        return AjaxJsonDto.fail("更新密码失败");
    }





}
