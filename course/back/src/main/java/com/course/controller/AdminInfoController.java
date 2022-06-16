package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.AdminInfo;
import com.course.pojo.StudentInfo;
import com.course.qo.AdminInfoQo;
import com.course.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminInfoController {


    @Autowired
    private AdminInfoService adminInfoService;

    @RequestMapping("/admin/login")
    public String adminLogin(@RequestBody AdminInfoQo adminInfoQo, HttpSession session){


        String code=adminInfoQo.getCode();
        if(!code.equalsIgnoreCase(String.valueOf(session.getAttribute("code")))){
            return AjaxJsonDto.fail("验证码输入错误");
        }
        AdminInfo adminInfo = adminInfoService.judgeLogin(adminInfoQo);
        if(adminInfo!=null){
            session.setAttribute("admin",adminInfo);
            return AjaxJsonDto.success("登录成功",adminInfo.getAdminName());
        }
        return AjaxJsonDto.fail("登录失败,账号密码有误");
    }
}
