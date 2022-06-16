package com.course.controller;

import com.course.dto.AjaxJsonDto;
import com.course.qo.CououtInfoQo;
import com.course.service.CououtInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CououtInfoController {



    @Autowired
    private CououtInfoService cououtInfoService;


    @RequestMapping("couout/addcouout")
    public String addCouout(@RequestBody CououtInfoQo cououtInfoQo){

        int result=cououtInfoService.addCouout(cououtInfoQo);
        if(result>0){
            return AjaxJsonDto.success("退课成功");
        }
        return AjaxJsonDto.fail("退课失败");
    }
}
