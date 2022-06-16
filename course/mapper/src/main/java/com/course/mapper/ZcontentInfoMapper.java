package com.course.mapper;

import com.course.qo.ZcontentInfoQo;
import com.course.vo.ZcontentInfoVo;

import java.util.List;

public interface ZcontentInfoMapper {

    int addZcontentInfo(ZcontentInfoQo zcontentInfoQo);

    List<ZcontentInfoVo> showAllZcontentByStudentId(ZcontentInfoQo zcontentInfoQo);

    Integer showAllZcontentByStudentIdCount(ZcontentInfoQo zcontentInfoQo);

    List<ZcontentInfoVo> showZcontentByStudentIdAndExamId(ZcontentInfoQo zcontentInfoQo);

    //更新内容的状态
    int updateZcontentState(ZcontentInfoQo zcontentInfoQo);

    //判断当前考试是否有主观题
    int judgeZhuguan(ZcontentInfoQo zcontentInfoQo);

    //查询该学生是否有考试
    int judgeStudentHasExam(ZcontentInfoQo zcontentInfoQo);
}
