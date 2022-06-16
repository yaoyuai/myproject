package com.course.controller;


import com.course.dto.AjaxJsonDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ExitController {

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return AjaxJsonDto.success("退出成功");

    }
}
