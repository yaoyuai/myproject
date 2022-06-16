package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.ParentInfo;
import com.course.qo.StudentInfoQo;
import com.course.service.CouselInfoService;
import com.course.service.StudentInfoService;
import com.course.vo.StudentInfoVo;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CouselInfoService couselInfoService;

    @RequestMapping("student/add")
    public String studentAdd(@RequestBody StudentInfoQo studentInfoQo){

        if (studentInfoService.judgeRegistHasName(studentInfoQo.getStudentName())!=null){
            return AjaxJsonDto.fail("已存在该账号，请重新输入");
        }

        int result=studentInfoService.adminAddStudent(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("添加学生成功");
        }
        return AjaxJsonDto.fail("添加学生失败");
    }



    @RequestMapping("student/list")
    public String studentList(StudentInfoQo studentInfoQo){
        List<StudentInfoVo> studentInfoVoList=studentInfoService.showAllStudent(studentInfoQo);
        int count=studentInfoService.showAllStudentCount(studentInfoQo);
        return AjaxJsonDto.success("",studentInfoVoList,count);
    }


    @RequestMapping("student/update")
    public String studentUpdate(@RequestBody StudentInfoQo studentInfoQo){
        int result=studentInfoService.adminUpdateStudent(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新学生成功");
        }
        return AjaxJsonDto.fail("更新学生失败");
    }


    @RequestMapping("student/logout")
    public String studentLogout(@RequestBody StudentInfoQo studentInfoQo){
        if(couselInfoService.selectStudentHasSel(studentInfoQo.getStudentId())!=null){
            return AjaxJsonDto.fail("该学生有选课，不能进行注销");
        }
        int result=studentInfoService.adminLogOutStudent(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注销学生成功");
        }
        return AjaxJsonDto.fail("注销学生失败");
    }
    
    

    @RequestMapping("/student/resetpwd")
    public String studentResetPwd(@RequestBody StudentInfoQo studentInfoQo){
        int result=studentInfoService.resetPwd(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("重置密码成功");
        }
        return AjaxJsonDto.fail("重置密码失败");
    }
    
    
    
    @RequestMapping("/student/showban")
    public String studentShowBan( StudentInfoQo studentInfoQo, HttpSession session){
        ParentInfo parentInfo = (ParentInfo) session.getAttribute("parent");
        studentInfoQo.setParentId(parentInfo.getParentId()+"");
        List<StudentInfoVo> studentInfoVoList=studentInfoService.showBan(studentInfoQo);
        int count=studentInfoService.showBanCount(studentInfoQo);
        return AjaxJsonDto.success("",studentInfoVoList,count);
    }

    @RequestMapping("student/ban")
    public String studentBan(@RequestBody StudentInfoQo studentInfoQo,HttpSession session){
        ParentInfo parentInfo = (ParentInfo) session.getAttribute("parent");
        studentInfoQo.setParentId(parentInfo.getParentId()+"");
        int result=studentInfoService.ban(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("绑定学生成功");
        }
        return AjaxJsonDto.fail("绑定学生失败");
    }



    @RequestMapping("student/jieban")
    public String studentJieBan(@RequestBody StudentInfoQo studentInfoQo){

        int result=studentInfoService.jieBan(studentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("解绑学生成功");
        }
        return AjaxJsonDto.fail("解绑学生失败");
    }



    @RequestMapping("student/showstudentbyparentid")
    public String studentShowStudentByParentId(@RequestBody StudentInfoQo studentInfoQo,HttpSession session){

        ParentInfo parentInfo = (ParentInfo) session.getAttribute("parent");

        studentInfoQo.setParentId(parentInfo.getParentId()+"");
        List<StudentInfoVo> studentInfoVoList=studentInfoService.showStudentByParentId(studentInfoQo);
        return AjaxJsonDto.success("",studentInfoVoList);
    }
}
