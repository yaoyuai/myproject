package com.course.service;

import com.course.pojo.TrainInfo;
import com.course.qo.TrainInfoQo;
import com.course.vo.ExamInfoVo;
import com.course.vo.TrainInfoVo;

import java.util.List;

public interface TrainInfoService {
    List<TrainInfoVo> showAllTrain(TrainInfoQo trainInfoQo);

    int showAllTrainCount(TrainInfoQo trainInfoQo);

    int deleteTrain(TrainInfoQo trainInfoQo);

    int updateTrain(TrainInfoQo trainInfoQo);

    int addTrain(TrainInfoQo trainInfoQo);

    TrainInfo selectHasTrain(String trainName,String courseId);

    List<TrainInfoVo> selectAllTrain(String teacherId);

    //查询前台的训练记录
    List<TrainInfoVo> selectAllTrainByCourseId(TrainInfoQo trainInfoQo);

    //查询前台的考试记录数量
    int selectAllTrainByCourseIdCount(TrainInfoQo trainInfoQo);

}
