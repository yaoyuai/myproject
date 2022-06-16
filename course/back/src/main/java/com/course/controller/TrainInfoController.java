package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.mapper.TrainInfoMapper;
import com.course.pojo.TeacherInfo;
import com.course.pojo.TrainInfo;
import com.course.qo.TrainInfoQo;
import com.course.service.TrainInfoService;
import com.course.vo.TrainInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TrainInfoController {

    @Autowired
    private TrainInfoService trainInfoService;



    @RequestMapping("/train/list")
    public String trainList(TrainInfoQo trainInfoQo, HttpSession session){
        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        trainInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        List<TrainInfoVo> trainInfoVoList = trainInfoService.showAllTrain(trainInfoQo);
        int count=trainInfoService.showAllTrainCount(trainInfoQo);
        return AjaxJsonDto.success("",trainInfoVoList,count);
    }


    @RequestMapping("/train/update")
    public String trainUpdate(@RequestBody TrainInfoQo trainInfoQo){
        if(trainInfoService.selectHasTrain(trainInfoQo.getTrainName(),trainInfoQo.getCourseId())!=null){
            return AjaxJsonDto.fail("已存在该训练，请重命名");
        }

        int result=trainInfoService.updateTrain(trainInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新成功");
        }
        return AjaxJsonDto.fail("更新失败");
    }


    @RequestMapping("/train/delete")
    public String trainDelete(@RequestBody TrainInfoQo trainInfoQo){

        int result=trainInfoService.deleteTrain(trainInfoQo);
        if(result>0){
            return AjaxJsonDto.success("删除成功");
        }
        return AjaxJsonDto.fail("删除失败");
    }

    @RequestMapping("/train/add")
    public String trainAdd(@RequestBody TrainInfoQo trainInfoQo,HttpSession session){
        if(trainInfoService.selectHasTrain(trainInfoQo.getTrainName(),trainInfoQo.getCourseId())!=null){
            return AjaxJsonDto.fail("已存在该训练，请重命名");
        }
        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        trainInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        int result=trainInfoService.addTrain(trainInfoQo);
        if(result>0){
            return AjaxJsonDto.success("添加成功");
        }
        return AjaxJsonDto.fail("添加失败");
    }


    @RequestMapping("/train/select")
    public String trainSelect(HttpSession session){

        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("teacher");
        List<TrainInfoVo> trainInfoVoList = trainInfoService.selectAllTrain(teacherInfo.getTeacherId() + "");
        return AjaxJsonDto.success("",trainInfoVoList);
    }




}
