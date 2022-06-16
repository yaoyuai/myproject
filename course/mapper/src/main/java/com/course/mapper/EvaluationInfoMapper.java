package com.course.mapper;

import com.course.pojo.EvaluationInfo;
import com.course.qo.EvaluationInfoQo;
import com.course.vo.EvaluationInfoVo;

import java.util.List;

public interface EvaluationInfoMapper {
    List<EvaluationInfoVo> showAllEvaluation(EvaluationInfoQo evaluationInfoQo);

    int showAllEvaluationCount(EvaluationInfoQo evaluationInfoQo);

    int addEvaluation(EvaluationInfoQo evaluationInfoQo);

    int deleteEvaluation(String evaluationId);

    List<EvaluationInfoVo> showAllEvaluationFrontList(EvaluationInfoQo evaluationInfoQo);

    int showAllEvaluationFrontListCount(EvaluationInfoQo evaluationInfoQo);

    EvaluationInfo selectStudentHasEvaluation(EvaluationInfoQo evaluationInfoQo);

}
