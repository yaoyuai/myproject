package com.course.controller;


import com.alibaba.fastjson.JSONObject;
import com.course.dto.JsonDto;
import com.course.pojo.AdminInfo;
import com.course.pojo.ParentInfo;
import com.course.pojo.TeacherInfo;
import com.course.service.MenuInfoService;
import com.course.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class ShowMenuNameController {


    @Autowired
    private MenuInfoService menuInfoService;


    @RequestMapping("/showMenuName")
    public String showMenuName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        JsonDto jsonDto=new JsonDto();
        HttpSession session=req.getSession();
        AdminInfo adminInfo = (AdminInfo)session.getAttribute("admin");
        TeacherInfo teacherInfo=(TeacherInfo)session.getAttribute("teacher");
        ParentInfo parentInfo=(ParentInfo)session.getAttribute("parent");
        int roleId=0;
        if(adminInfo!=null){
            roleId=adminInfo.getRoleId();
        }else if(teacherInfo!=null){
            roleId=teacherInfo.getRoleId();
        }else if(parentInfo!=null){
            roleId=parentInfo.getRoleId();
        }






//        MenuInfoService menuInfoService = SpringUtils.getBean(MenuInfoService.class);
        List<MenuInfoVo> menuInfoVoList = menuInfoService.showAllMenu(roleId);
        jsonDto.getMap().put("list",menuInfoVoList);
        jsonDto.setId(1);
        return JSONObject.toJSONString(jsonDto);
    }


}
