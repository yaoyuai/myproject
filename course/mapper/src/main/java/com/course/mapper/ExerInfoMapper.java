package com.course.mapper;

import com.course.pojo.ExerInfo;
import com.course.qo.ExerInfoQo;
import com.course.vo.ExerInfoVo;

import java.util.List;

public interface ExerInfoMapper {
    int addExer(ExerInfoQo exerInfoQo);

    int selectMaxExerId();

    //根据考试id查询 该考试对应的题目
    List<ExerInfoVo> showAllExerByExamId(ExerInfoQo exerInfoQo);

    //查询某场考试是否有主观题
    List<ExerInfoVo> selectOneExamHasTianKong(ExerInfoQo exerInfoQo);

    //根据训练id查询 该训练对应的题目
    List<ExerInfoVo> showAllExerByTrainId(ExerInfoQo exerInfoQo);

    //统计考试总分
    Integer sumExamScore(ExerInfoQo exerInfoQo);

    //更新题目答案
    int updateAnswer(ExerInfoQo exerInfoQo);

    //查询考试是否有发布题目
    int showExamHasExer(ExerInfoQo exerInfoQo);

}
