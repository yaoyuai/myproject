package com.course.controller;

import com.course.dto.AjaxJsonDto;
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

    @RequestMapping("evaluation/list")
    public String evaluationList(EvaluationInfoQo evaluationInfoQo){

        List<EvaluationInfoVo> evaluationInfoVoList=evaluationInfoService.showAllEvaluation(evaluationInfoQo);
        int count=evaluationInfoService.showAllEvaluationCount(evaluationInfoQo);
        return AjaxJsonDto.success("",evaluationInfoVoList,count);
    }


    @RequestMapping("evaluation/add")
    public String evaluationAdd(@RequestBody EvaluationInfoQo evaluationInfoQo, HttpSession session){

        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        evaluationInfoQo.setStudentId(studentInfo.getStudentId()+"");
        int result=evaluationInfoService.addEvaluation(evaluationInfoQo);
        if(result>0){
            AjaxJsonDto.success("评价成功");
        }
        return AjaxJsonDto.fail("评价失败");
    }


    @RequestMapping("evaluation/delete")
    public String evaluationDelete(@RequestBody EvaluationInfoQo evaluationInfoQo){

        System.out.println(evaluationInfoQo.getEvaluationId()+"这是id");
        int result=evaluationInfoService.deleteEvaluation(evaluationInfoQo.getEvaluationId());
        if(result>0){
            return AjaxJsonDto.success("删除成功");
        }
        return AjaxJsonDto.fail("删除失败");
    }
}
