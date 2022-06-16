package com.course.service.impl;

import com.course.mapper.ExamInfoMapper;
import com.course.pojo.ExamInfo;
import com.course.qo.ExamInfoQo;
import com.course.qo.ExerInfoQo;
import com.course.service.ExamInfoService;
import com.course.vo.ExamInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamInfoServiceImpl implements ExamInfoService {

    @Autowired
    private ExamInfoMapper examInfoMapper;


    @Override
    public List<ExamInfoVo> showAllExam(ExamInfoQo examInfoQo) {
        if(examInfoQo.getExamName()==null || examInfoQo.getExamName().trim().isEmpty()){
            examInfoQo.setExamName(null);
        }
        if(examInfoQo.getCourseName()==null || examInfoQo.getCourseName().trim().isEmpty()){
            examInfoQo.setCourseName(null);
        }
        if(examInfoQo.getStateId()==null || examInfoQo.getStateId().equals("-1")){
            examInfoQo.setStateId(null);
        }
        return examInfoMapper.showAllExam(examInfoQo);
    }

    @Override
    public int showAllExamCount(ExamInfoQo examInfoQo) {
        if(examInfoQo.getExamName()==null || examInfoQo.getExamName().trim().isEmpty()){
            examInfoQo.setExamName(null);
        }
        if(examInfoQo.getCourseName()==null || examInfoQo.getCourseName().trim().isEmpty()){
            examInfoQo.setCourseName(null);
        }
        if(examInfoQo.getStateId()==null || examInfoQo.getStateId().equals("-1")){
            examInfoQo.setStateId(null);
        }
        return examInfoMapper.showAllExamCount(examInfoQo);
    }

    @Override
    public int addExam(ExamInfoQo examInfoQo) {
        if(examInfoQo.getExamName()==null || examInfoQo.getExamName().trim().isEmpty()){
            return -1;
        }
        if(examInfoQo.getCourseId()==null || examInfoQo.getCourseId().equals("-1")){
            return -1;
        }
        if(examInfoQo.getTeacherId()==null){
            return -1;
        }
        return examInfoMapper.addExam(examInfoQo);
    }

    @Override
    public int updateExam(ExamInfoQo examInfoQo) {
        if(examInfoQo.getExamName()==null || examInfoQo.getExamName().trim().isEmpty()){
            return -1;
        }
        if(examInfoQo.getCourseId()==null || examInfoQo.getCourseId().equals("-1")){
            return -1;
        }
        return examInfoMapper.updateExam(examInfoQo);
    }

    @Override
    public int deleteExam(ExamInfoQo examInfoQo) {
        return examInfoMapper.deleteExam(examInfoQo);
    }

    @Override
    public ExamInfo selectHasExam(String examName,String courseId) {
        return examInfoMapper.selectHasExam(examName,courseId);
    }

    @Override
    public List<ExamInfoVo> selectAllExam(String teacherId) {
        return examInfoMapper.selectAllExam(teacherId);
    }

    @Override
    public List<ExamInfoVo> selectAllExamByCourseId(ExamInfoQo examInfoQo) {
        return examInfoMapper.selectAllExamByCourseId(examInfoQo);
    }

    @Override
    public int selectAllExamByCourseIdCount(ExamInfoQo examInfoQo) {
        return examInfoMapper.selectAllExamByCourseIdCount(examInfoQo);
    }

    @Override
    public List<ExamInfoVo> showAllExamByTeacherId(ExamInfoQo examInfoQo) {
        return examInfoMapper.showAllExamByTeacherId(examInfoQo);
    }

    @Override
    public List<ExamInfoVo> showAllExamByCourseId(ExamInfoQo examInfoQo) {
        return examInfoMapper.showAllExamByCourseId(examInfoQo);
    }

    @Override
    public int updateExamStateFabu(ExamInfoQo examInfoQo) {
        return examInfoMapper.updateExamStateFabu(examInfoQo);
    }
}
