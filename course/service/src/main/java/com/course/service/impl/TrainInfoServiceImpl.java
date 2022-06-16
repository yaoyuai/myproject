package com.course.service.impl;
import com.course.mapper.TrainInfoMapper;
import com.course.pojo.TrainInfo;
import com.course.qo.TrainInfoQo;
import com.course.service.TrainInfoService;
import com.course.vo.ExamInfoVo;
import com.course.vo.TrainInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainInfoServiceImpl implements TrainInfoService {

    @Autowired
    private TrainInfoMapper trainInfoMapper;

    @Override
    public List<TrainInfoVo> showAllTrain(TrainInfoQo trainInfoQo) {
        if(trainInfoQo.getTrainName()==null || trainInfoQo.getTrainName().trim().isEmpty()){
            trainInfoQo.setTrainName(null);
        }
        if(trainInfoQo.getCourseName()==null || trainInfoQo.getCourseName().trim().isEmpty()){
            trainInfoQo.setCourseName(null);
        }
        if(trainInfoQo.getStateId()==null || trainInfoQo.getStateId().equals("-1")){
            trainInfoQo.setStateId(null);
        }
        return trainInfoMapper.showAllTrain(trainInfoQo);
    }

    @Override
    public int showAllTrainCount(TrainInfoQo trainInfoQo) {
        if(trainInfoQo.getTrainName()==null || trainInfoQo.getTrainName().trim().isEmpty()){
            trainInfoQo.setTrainName(null);
        }
        if(trainInfoQo.getCourseName()==null || trainInfoQo.getCourseName().trim().isEmpty()){
            trainInfoQo.setCourseName(null);
        }
        if(trainInfoQo.getStateId()==null || trainInfoQo.getStateId().equals("-1")){
            trainInfoQo.setStateId(null);
        }
        return trainInfoMapper.showAllTrainCount(trainInfoQo);
    }

    @Override
    public int deleteTrain(TrainInfoQo trainInfoQo) {
        return trainInfoMapper.deleteTrain(trainInfoQo);
    }

    @Override
    public int updateTrain(TrainInfoQo trainInfoQo) {
        if(trainInfoQo.getTrainName()==null || trainInfoQo.getTrainName().trim().isEmpty()){
            return -1;
        }
        if(trainInfoQo.getCourseId()==null || trainInfoQo.getCourseId().equals("-1")){
            return -1;
        }
        return trainInfoMapper.updateTrain(trainInfoQo);
    }

    @Override
    public int addTrain(TrainInfoQo trainInfoQo) {
        if(trainInfoQo.getTrainName()==null || trainInfoQo.getTrainName().trim().isEmpty()){
            return -1;
        }
        if(trainInfoQo.getCourseId()==null || trainInfoQo.getCourseId().equals("-1")){
            return -1;
        }
        if(trainInfoQo.getTeacherId()==null){
            return -1;
        }
        return trainInfoMapper.addTrain(trainInfoQo);
    }

    @Override
    public TrainInfo selectHasTrain(String trainName,String courseId) {
        return trainInfoMapper.selectHasTrain(trainName,courseId);
    }

    @Override
    public List<TrainInfoVo> selectAllTrain(String teacherId) {
        return trainInfoMapper.selectAllTrain(teacherId);
    }

    @Override
    public List<TrainInfoVo> selectAllTrainByCourseId(TrainInfoQo trainInfoQo) {
        return trainInfoMapper.selectAllTrainByCourseId(trainInfoQo);
    }

    @Override
    public int selectAllTrainByCourseIdCount(TrainInfoQo trainInfoQo) {
        return trainInfoMapper.selectAllTrainByCourseIdCount(trainInfoQo);
    }
}
