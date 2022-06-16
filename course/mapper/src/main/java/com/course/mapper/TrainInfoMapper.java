package com.course.mapper;


import com.course.pojo.TrainInfo;
import com.course.qo.ExamInfoQo;
import com.course.qo.TrainInfoQo;
import com.course.vo.ExamInfoVo;
import com.course.vo.TrainInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainInfoMapper {

    List<TrainInfoVo> showAllTrain(TrainInfoQo trainInfoQo);

    int showAllTrainCount(TrainInfoQo trainInfoQo);

    int deleteTrain(TrainInfoQo trainInfoQo);

    int updateTrain(TrainInfoQo trainInfoQo);

    int addTrain(TrainInfoQo trainInfoQo);

    TrainInfo selectHasTrain(@Param("trainName") String trainName,@Param("courseId")String courseId);

    List<TrainInfoVo> selectAllTrain(String teacherId);


    //查询前台的训练记录
    List<TrainInfoVo> selectAllTrainByCourseId(TrainInfoQo trainInfoQo);

    //查询前台的考试记录数量
    int selectAllTrainByCourseIdCount(TrainInfoQo trainInfoQo);

}
