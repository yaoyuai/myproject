package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.qo.TrainInfoQo;
import com.course.service.TrainInfoService;
import com.course.vo.TrainInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainInfoController {

    @Autowired
    private TrainInfoService trainInfoService;


    @RequestMapping("/train/selecttrainbycourseid")
    public String trainSelectTrainByCourseId(@RequestBody TrainInfoQo trainInfoQo){
        List<TrainInfoVo> trainInfoVoList=trainInfoService.selectAllTrainByCourseId(trainInfoQo);
        int count=trainInfoService.selectAllTrainByCourseIdCount(trainInfoQo);
        return AjaxJsonDto.success("",trainInfoVoList,count);
    }
}
