package com.course.controller;

import com.course.dto.AjaxJsonDto;
import com.course.pojo.EvaluationInfo;
import com.course.pojo.StudentInfo;
import com.course.qo.EvaluationInfoQo;
import com.course.service.EvaluationInfoService;
import com.course.vo.EvaluationInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class EvaluationInfoController {

    @Autowired
    private EvaluationInfoService evaluationInfoService;

    @RequestMapping("evaluation/front/list")
    public String evaluationFrontList(@RequestBody EvaluationInfoQo evaluationInfoQo){
        System.out.println(evaluationInfoQo.getCourseId()+"--");
        List<EvaluationInfoVo> evaluationInfoVoList=evaluationInfoService.showAllEvaluationFrontList(evaluationInfoQo);
        int count=evaluationInfoService.showAllEvaluationFrontListCount(evaluationInfoQo);
        System.out.println(evaluationInfoVoList);
        return AjaxJsonDto.success("",evaluationInfoVoList,count);
    }

    @RequestMapping("evaluation/list")
    public String evaluationList(EvaluationInfoQo evaluationInfoQo){
        List<EvaluationInfoVo> evaluationInfoVoList=evaluationInfoService.showAllEvaluation(evaluationInfoQo);
        int count=evaluationInfoService.showAllEvaluationCount(evaluationInfoQo);
        return AjaxJsonDto.success("",evaluationInfoVoList,count);
    }


    @RequestMapping("evaluation/add")
    public String evaluationAdd(EvaluationInfoQo evaluationInfoQo, HttpSession session){

        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        evaluationInfoQo.setStudentId(studentInfo.getStudentId()+"");
        int result=evaluationInfoService.addEvaluation(evaluationInfoQo);
        if(result>0){
            AjaxJsonDto.success("评价成功");
        }
        return AjaxJsonDto.fail("评价失败");
    }


    @RequestMapping("evaluation/delete")
    public String evaluationDelete(EvaluationInfoQo evaluationInfoQo){

        int result=evaluationInfoService.deleteEvaluation(evaluationInfoQo.getEvaluationId());
        if(result>0){
            AjaxJsonDto.success("删除成功");
        }
        return AjaxJsonDto.fail("删除失败");
    }


    @RequestMapping("evluation/selectstudenthas")
    public String evaluationSelectStudentHas(@RequestBody EvaluationInfoQo evaluationInfoQo,HttpSession session){

        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        evaluationInfoQo.setStudentId(studentInfo.getStudentId()+"");
        EvaluationInfo evaluationInfo=evaluationInfoService.selectStudentHasEvaluation(evaluationInfoQo);
        if(evaluationInfo!=null){
            System.out.println("执行了----奥术大师");
            return AjaxJsonDto.success("");
        }
        return AjaxJsonDto.fail("");
    }
}
