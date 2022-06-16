package com.course.service;

import com.course.pojo.ExamInfo;
import com.course.qo.ExamInfoQo;
import com.course.qo.ExerInfoQo;
import com.course.vo.ExamInfoVo;

import java.util.List;

//考试信息 接口类
public interface ExamInfoService {


    List<ExamInfoVo> showAllExam(ExamInfoQo examInfoQo);

    int showAllExamCount(ExamInfoQo  examInfoQo);

    int addExam(ExamInfoQo examInfoQo);

    int updateExam(ExamInfoQo examInfoQo);

    int deleteExam(ExamInfoQo examInfoQo);

    ExamInfo selectHasExam(String examName,String courseId);

    List<ExamInfoVo> selectAllExam(String teacherId);


    //查询前台的考试记录
    List<ExamInfoVo> selectAllExamByCourseId(ExamInfoQo examInfoQo);

    //查询前台的考试记录数量
    int selectAllExamByCourseIdCount(ExamInfoQo examInfoQo);

    //根据教师id查询教师id发布的考试
    List<ExamInfoVo> showAllExamByTeacherId(ExamInfoQo examInfoQo);

    //根据课程id找到对应的考试
    List<ExamInfoVo> showAllExamByCourseId(ExamInfoQo examInfoQo);

    //发布考试更新考试状态
    int updateExamStateFabu(ExamInfoQo examInfoQo);

}
