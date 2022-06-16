package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.qo.ExerInfoQo;
import com.course.service.ExerInfoService;
import com.course.vo.ExerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerInfoController {


    @Autowired
    private ExerInfoService exerInfoService;


    @RequestMapping("exer/showallexerbyexamid")
    public String exerAdd(@RequestBody ExerInfoQo exerInfoQo){
        List<ExerInfoVo> exerInfoVoList=exerInfoService.showAllExerByExamId(exerInfoQo);
        return AjaxJsonDto.success("",exerInfoVoList);
    }


    @RequestMapping("exer/showallexerbytrainid")
    public String exerShowAllExerByTrainId(@RequestBody ExerInfoQo exerInfoQo){
        List<ExerInfoVo> exerInfoVoList=exerInfoService.showAllExerByTrainId(exerInfoQo);
        return AjaxJsonDto.success("",exerInfoVoList);
    }
}
