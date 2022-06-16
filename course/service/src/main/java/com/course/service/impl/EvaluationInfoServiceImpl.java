package com.course.service.impl;

import com.course.mapper.EvaluationInfoMapper;
import com.course.pojo.EvaluationInfo;
import com.course.qo.EvaluationInfoQo;
import com.course.service.EvaluationInfoService;
import com.course.vo.EvaluationInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService {

    @Autowired
    private EvaluationInfoMapper evaluationInfoMapper;

    @Override
    public List<EvaluationInfoVo> showAllEvaluation(EvaluationInfoQo evaluationInfoQo) {
        if(evaluationInfoQo.getCourseName()==null || evaluationInfoQo.getCourseName().trim().isEmpty()){
            evaluationInfoQo.setCourseName(null);
        }
        if(evaluationInfoQo.getStudentName()==null || evaluationInfoQo.getStudentName().trim().isEmpty()){
            evaluationInfoQo.setStudentName(null);
        }
        if(evaluationInfoQo.getEvaluationScore()==null || evaluationInfoQo.getEvaluationScore().equals("-1")){
            evaluationInfoQo.setEvaluationScore(null);
        }
        return evaluationInfoMapper.showAllEvaluation(evaluationInfoQo);
    }

    @Override
    public int showAllEvaluationCount(EvaluationInfoQo evaluationInfoQo) {
        if(evaluationInfoQo.getCourseName()==null || evaluationInfoQo.getCourseName().trim().isEmpty()){
            evaluationInfoQo.setCourseName(null);
        }
        if(evaluationInfoQo.getStudentName()==null || evaluationInfoQo.getStudentName().trim().isEmpty()){
            evaluationInfoQo.setStudentName(null);
        }
        if(evaluationInfoQo.getEvaluationScore()==null || evaluationInfoQo.getEvaluationScore().equals("-1")){
            evaluationInfoQo.setEvaluationScore(null);
        }
        return evaluationInfoMapper.showAllEvaluationCount(evaluationInfoQo);
    }

    @Override
    public int addEvaluation(EvaluationInfoQo evaluationInfoQo) {
        if(evaluationInfoQo.getStudentId()==null){
            return -1;
        }
        if(evaluationInfoQo.getEvaluationScore()==null || evaluationInfoQo.getEvaluationScore().trim().isEmpty()){
            return -1;
        }
        if(evaluationInfoQo.getEvaluationContent()==null || evaluationInfoQo.getEvaluationContent().trim().isEmpty()){
            return -1;
        }
        if(evaluationInfoQo.getCourseId()==null){
            return -1;
        }


        return evaluationInfoMapper.addEvaluation(evaluationInfoQo);
    }

    @Override
    public int deleteEvaluation(String evaluationId) {
        return evaluationInfoMapper.deleteEvaluation(evaluationId);
    }

    @Override
    public List<EvaluationInfoVo> showAllEvaluationFrontList(EvaluationInfoQo evaluationInfoQo) {
        return evaluationInfoMapper.showAllEvaluationFrontList(evaluationInfoQo);
    }

    @Override
    public int showAllEvaluationFrontListCount(EvaluationInfoQo evaluationInfoQo) {
        return evaluationInfoMapper.showAllEvaluationFrontListCount(evaluationInfoQo);
    }

    @Override
    public EvaluationInfo selectStudentHasEvaluation(EvaluationInfoQo evaluationInfoQo) {
        return evaluationInfoMapper.selectStudentHasEvaluation(evaluationInfoQo);
    }
}
